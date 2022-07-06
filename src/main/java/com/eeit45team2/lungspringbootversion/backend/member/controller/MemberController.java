package com.eeit45team2.lungspringbootversion.backend.member.controller;

import com.eeit45team2.lungspringbootversion.backend.member.model.MemberBean;
import com.eeit45team2.lungspringbootversion.backend.member.service.MemberService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/Backendmember")
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	ServletContext ctx;

	String imageLocation = "resources\\images\\memberHeadshot";
	String memberHeadshotDir = "./src/main/resources/static/BackEnd/images/memberHeadshot/";
	
	@Autowired
	public MemberController(MemberService memberService,ServletContext ctx) {
		this.memberService = memberService;
		this.ctx = ctx;
	}

	/* 匯入CSV時把專案下的圖片set到DB，查詢會員頁面時再把DB的圖片抓到畚箕Server下  */
	@GetMapping("/memberlist")  // 查詢(用GET)
	public String listMembers(Model model) {
		List<MemberBean> memberBeans = memberService.findAll();
//		for( MemberBean member  : memberBeans  ) {
//				downloadDBInitImage(member);
//		}
//		if(memberBeans.size() >0){
//			if(memberBeans.get(0).getLocalfileName().equals("defaultHeadshot.jpg")) {
//				memberBeans.remove(0);  // 不顯示default user
//			}
//		}
		model.addAttribute("members", memberBeans);
		return "Backendmember/backmember";
	}

	@GetMapping("/showForm")  // 顯示新增表單
	public String showFormForAdd(Model model) {
		MemberBean memberBean = new MemberBean(); 
		model.addAttribute("member", memberBean); 
		return "Backendmember/memberNewForm";
	}

	@PostMapping(value ="/saveMember")  // 新增或更新
	public String saveMember(@ModelAttribute("member") MemberBean memberBean) {
//		System.out.println(" > getMi_birth: " + (memberBean.getMi_birth()==null));
//		System.out.println(" > getImage: " + (memberBean.getImage()==null));
		Boolean isInsert = (memberBean.getMi_no() ==null); // 判斷是否為insert
		
		MemberBean memberBean1 = saveHeadshotInDB(memberBean,isInsert);  // 取得MultipartFile，把圖片以BLOB型態塞進DB //setImage( )
		System.out.println("memberBean1的localfilename: " + memberBean1.getLocalfileName());
//		saveHeadshotInLocal(memberBean1,isInsert);  // 把圖片塞到本機 && setLocalfileName()
		memberService.save(memberBean1);  // 塞進DB後才產生mi_no
		
		return "redirect:/Backendmember/memberlist";  // 重導到查詢頁面 //redirect不帶資料
	}

	@GetMapping("/updateForm/{mi_no}")  // 顯示更新頁面
	public ModelAndView showFormForUpdate(@PathVariable Long mi_no) {
		ModelAndView mav = new ModelAndView("Backendmember/memberEditForm");//指向memberEditForm.html
		MemberBean memberBean = memberService.findById(mi_no);
		mav.addObject("member", memberBean);
		return mav;
	}
	
	@GetMapping("/delete/{mi_no}")  //刪除
	public String deleteMember(@PathVariable Long mi_no) {
		memberService.delete(mi_no);
		return "redirect:/Backendmember/memberlist";
	}






	@PostMapping(value = "/CheckMemberAccount", produces = { "application/json" })
	public @ResponseBody Map<String, Boolean> existsByMiAccount(@RequestParam("accountToCheck") String miAccount) {
		Map<String, Boolean> map = new HashMap<>();
		Boolean accountExisted = memberService.existsByMiAccount(miAccount);
		map.put("accountExisted", accountExisted);
		return map;
	}


	
	// 讓「查詢頁面」可以取得圖片欄
	@GetMapping("/picture/{mi_no}")
	public ResponseEntity<byte[]> getPicture(@PathVariable("mi_no") Long mi_no) {
		byte[] body = null;
		ResponseEntity<byte[]> responseEntity = null;
		MediaType mediaType = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		MemberBean member = memberService.findById(mi_no);

		// 沒有會員資料
		if(member == null) {
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}else {
		// 有會員資料
			String localfilename = member.getLocalfileName();
//			Blob image = member.getImage();
			// 有local檔名 -> 因為csv直接匯入 || 有新增照片
			if(localfilename != null) {
				// 設定ResponseHeaders
				/* 透過檔名 setContentType(MediaType) */
				if (localfilename.toLowerCase().endsWith("jfif")) {
					mediaType = MediaType.valueOf(ctx.getMimeType("dummy.jpeg"));
				} else {
					mediaType = MediaType.valueOf(ctx.getMimeType(localfilename));
					headers.setContentType(mediaType);
				}
				// 設定ResponseBody
//				body = getServerFileToByteArray("/resources/images/memberHeadshot" + localfilename);  //有問題: 每次都產生暫時目錄
				body = blobToByteArray(member.getImage()); // 改成抓DB圖片
			}else {
			//沒有local檔名 -> 新增不傳圖片 -> 所以要顯示預設圖片
				body = getProjectFileToByteArray(".\\src\\main\\resources\\static\\BackEnd\\images\\memberHeadshot\\defaultHeadshot.jpg");  //如果圖片為空，就上傳預設圖片
			}
			responseEntity = new ResponseEntity<byte[]>(body, headers, HttpStatus.OK);
			return responseEntity;
		}	
	}
		
	/* 專案下路徑 */
	public byte[] getProjectFileToByteArray(String path){
		byte[] result = null;
		Path projectPath = Paths.get(path);
		if (!Files.exists(projectPath)) {
			try {
				Files.createDirectories(projectPath);
			} catch (IOException e) {
				System.out.println("創建專案下會員大頭照資料夾時，發生錯誤");
				e.printStackTrace();
			}
		}
		try (InputStream is = new FileInputStream(new File(path));
			 ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
			byte[] b = new byte[819200];
			int len = 0;
			while ((len = is.read(b)) != -1) {
				baos.write(b, 0, len);
			}
			result = baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/* tomcat下路徑 */
	private byte[] getServerFileToByteArray(String path) {
		byte[] result = null;
		try (InputStream is = ctx.getResourceAsStream(path);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
			byte[] b = new byte[819200];
			int len = 0;
			while ((len = is.read(b)) != -1) {
				baos.write(b, 0, len);
			}
			result = baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public byte[] blobToByteArray(Blob blob) {
		byte[] result = null;
		try (InputStream is = blob.getBinaryStream(); ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
			byte[] b = new byte[819200];
			int len = 0;
			while ((len = is.read(b)) != -1) {
				baos.write(b, 0, len);
			}
			result = baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
	
	
	
	// MultipartFile 轉 BLOB型態 ，塞進DB
	public MemberBean saveHeadshotInDB(MemberBean memberBean, Boolean isInsert) {
		MultipartFile picture = memberBean.getProductImage(); //取得MultipartFile檔案
		// setImage (建立Blob物件，交由 Hibernate 寫入資料庫)
		if (picture != null && !picture.isEmpty()) {
			// 如果有上傳照片
			try {
				byte[] b = picture.getBytes();
				Blob blob = new SerialBlob(b);
				memberBean.setImage(blob);   //塞BLOB
				memberBean.setLocalfileName(System.currentTimeMillis() + "_" + picture.getOriginalFilename()); // 暫時先這樣寫
				return memberBean;
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}else { 
			// 如果沒有上傳照片
			if( !isInsert ) { // 是update時
				try {
					memberBean.setImage(memberService.findById(memberBean.getMi_no()).getImage());  // 找DB中的舊照片
					System.out.println(" > setImaget 成功");
					return memberBean;
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException("修改時 檔案上傳發生異常: " + e.getMessage());
				}	
			} // 不是update時不用setImage
			return memberBean;
		}
	}
	
	
	// 把圖片塞到本機(放在此專案下)
//	public void saveHeadshotInLocal(MemberBean memberBean, Boolean isInsert) {
//		String contextPath = ctx.getRealPath("");
//        System.out.println("contextPath: " + contextPath);
//		String savePath = contextPath + imageLocation /* + File.separator*/;
//		System.out.println(" > savePath: " + savePath);
//		// 建立資料夾
//		File fileSaveDir = new File(savePath); //Server端的站存資料夾 -> D:\1_iSpan\_TeamWork\teamWorkSpace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Lung-springmvc\resource\images\localImage
////		File fileSaveDir = new File(memberHeadshotDir);
//		System.out.println(" > fileSaveDir: " + fileSaveDir);
//		if (!fileSaveDir.exists()) {
//			Boolean mkdirSuccess = fileSaveDir.mkdirs(); /*如果沒有這個資料夾，就建立資料夾*/
//		}
//		// 把圖片存到本機資料夾
//		String filename = null;
//		MultipartFile picture = memberBean.getProductImage();
//		// 如果有取得MultipartFile(有上傳照片)
//		if (picture != null && !picture.isEmpty()) {
//			// setLocalfileName( ) && 存圖片到本機
//			// 不管是insert 或 update都要執行
//			try {
//				filename =  System.currentTimeMillis() + "_" + picture.getOriginalFilename();  //串接檔名 -> 毫秒_原始檔名
//				File saveFile = new File(fileSaveDir, filename);
//				picture.transferTo(saveFile);  // 存到硬碟
//				memberBean.setLocalfileName(filename);
//				System.out.println(" > LocalfileName:" + filename);
//				System.out.println(" > 照片存到本機專案下 -> 成功");
//			} catch (IOException e) {
//				e.printStackTrace();
//				System.out.println(" > 修改時 照片存到本機有問題");
//			}
//			// 是update時
//			if( !isInsert ) {
//				try {
//					// 刪除本機舊照片
//					deleteHeadshotInLocal(memberBean);
//				} catch (Exception e) {
//					System.out.println(" > 修改時 刪除本機照片有問題");
//				}
//			}
//		}else {
//		// 如果沒有取得MultipartFile(沒有上傳照片)
//			if( !isInsert ) {
//				// 是update時
//				try {
//					memberBean.setLocalfileName(memberService.findById(memberBean.getMi_no()).getLocalfileName());
//					System.out.println(" > setLocalfileName 成功");
//				} catch (Exception e) {
//					e.printStackTrace();
//					throw new RuntimeException("修改時 setLocalfileName()發生異常: " + e.getMessage());
//				}
//			}else {
//				// 不是update時不用setLocalfileName
//				System.out.println(" > 離開 saveHeadshotInLocal()");
//			}
//		}
//	 }


//	public void deleteHeadshotInLocal(MemberBean member) {
//		String contextPath = ctx.getRealPath("");
//		String filePath = contextPath + imageLocation + File.separator;
//		System.out.println(" > filePath: " + filePath);
//
//		String oldFilenameString = memberService.findById(member.getMi_no()).getLocalfileName();  //找到本地的舊檔名
//		System.out.println(" > oldFilenameString:" + oldFilenameString);
//		try {
//			File file = new File(filePath + oldFilenameString);
////			File file = new File(memberHeadshotDir + oldFilenameString);
//			file.delete();
//			System.out.println(" > 本地圖片檔已被刪除");
//			System.out.println(" > 刪除的檔名為: " + oldFilenameString);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println(" > 刪除檔案有錯");
//		}
//	}
	

	// blob - >
	public void downloadDBInitImage(MemberBean memberBean) {
		String contextPath = ctx.getRealPath("");
		String savePath = contextPath + imageLocation /* + File.separator*/;
		System.out.println(" > download Image location: " + savePath);
		// 建立資料夾
		File fileSaveDir = new File(savePath); //Server端的站存資料夾 -> D:\1_iSpan\_TeamWork\teamWorkSpace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Lung-springmvc\resource\images\localImage
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir(); /*如果沒有這個資料夾，就建立資料夾*/  
		}
		// 把圖片存到本機資料夾
		String filename = null;
		Blob blob = memberBean.getImage();
		// 如果有取得MultipartFile(有上傳照片)
		if (blob != null) {
			// setLocalfileName( ) && 存圖片到本機
			// 不管是insert 或 update都要執行
			try {
				filename = memberBean.getLocalfileName();
				File saveFile = new File(fileSaveDir, filename);
				if (saveFile.exists()) {
					return;
				}
				FileUtils.writeByteArrayToFile(saveFile, blobToByteArray(blob));
				System.out.println(" > LocalfileName:" + filename);
				System.out.println(" > 抓DB照片存到本機專案下 -> 成功");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	 }	
	
	
	
	
	
	
	
	
}
