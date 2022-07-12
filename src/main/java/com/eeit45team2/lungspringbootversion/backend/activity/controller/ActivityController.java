package com.eeit45team2.lungspringbootversion.backend.activity.controller;

import com.eeit45team2.lungspringbootversion.backend.activity.model.ActivityBean;
import com.eeit45team2.lungspringbootversion.backend.activity.model.MemberActivityBean;
import com.eeit45team2.lungspringbootversion.backend.activity.service.ActivityService;
import com.eeit45team2.lungspringbootversion.backend.activity.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;


@Controller
@RequestMapping("/Backendactivity")
public class ActivityController {

	@Autowired
	ServletContext ctx; //自動注入物件ServletContext
	
	String imageLocation = "resources\\images\\activityImage";
	String uploadDir = "./src/main/resources/static/BackEnd/images/activity/"  ;



	@Autowired
	private ActivityService ActivityService;

	@Autowired
	public ActivityController(ActivityService activityService,ServletContext ctx) {
		this.ActivityService = activityService;
		this.ctx = ctx;
	}

	@GetMapping("/activitylist")
	public String listActivity(Model model) {//model.addAttribute=req.setAttribute
		List<ActivityBean> activityBeans = ActivityService.findAll();
		model.addAttribute("activities", activityBeans);
		return "Backendactivity/BackActivity";
	}

	@GetMapping("/APlist")
	public String listAP(Model model) {//model.addAttribute=req.setAttribute
		List<MemberActivityBean> memberActivityBeans = ActivityService.findAllAP();
		model.addAttribute("AP", memberActivityBeans);
		return "Backendactivity/BackAP";
	}

	@RequestMapping("/acShowForm")
	public String showFormForAdd(Model model) {
		ActivityBean ActivityBean = new ActivityBean();
		model.addAttribute("activity", ActivityBean);
		return "Backendactivity/activityNewForm";
	}

	@PostMapping("/saveActivity")
	public String saveActivity(ActivityBean ActivityBean,
							   @RequestParam("image") MultipartFile multipartFile) throws IOException {
//		System.out.println("getImage: " + (ActivityBean.getImage()==null));
		String fileName = System.currentTimeMillis() + "_" + StringUtils.cleanPath(multipartFile.getOriginalFilename());
		ActivityBean.setLocalFileName(fileName);
		ActivityService.save(ActivityBean);
//		String uploadDir = "./src/main/resources/static/BackEnd/images/activity/"  ;
//		FileUploadUtil.saveFile(imageLocation, fileName, multipartFile);
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		return "redirect:/Backendactivity/activitylist";
	}
	@PostMapping("/saveAP")
	public String saveAP(MemberActivityBean memberActivityBean,
						 @RequestParam("ac_id") Integer ac_id,
						 @RequestParam("mi_no") Integer mi_no
	) {
		memberActivityBean.setDate(LocalDateTime.now());
		memberActivityBean.setAc_id(ac_id);
		memberActivityBean.setMi_no(mi_no);
		ActivityService.saveAP(memberActivityBean);

		return "redirect:/Backendactivity/APlist";
	}

	@GetMapping ("/saveActivity1")
	public String saveActivity1(ActivityBean ActivityBean) {
		ActivityBean.setAc_name("台中市動物保護志工招募");
		ActivityBean.setLocalFileName("可愛貓貓.jpg");
		ActivityBean.setAc_date(Date.valueOf("2022-01-01"));
		ActivityBean.setAc_participant("關心動物保護議題，卻不知如何投入動物保護第一線嗎？台中動保處今年的志工招募活動開跑了!台中的朋友們可別錯過這個機會，服務內容包含推廣動物保護觀念、協助追蹤動保案件，以及照顧、陪伴園區內的犬貓，服務內容為協助動保處進行動物保護宣導活動、動保案件稽查，動物之家園區介紹導覽、照顧園內犬貓、推廣認領養等等。多元的服務內容，能讓大家發揮所長一同為動物盡一份力量！");
		ActivityBean.setAc_venue("地點");
		ActivityBean.setAc_quota(50);
		ActivityBean.setAc_waitlist_quota(0);
		ActivityBean.setAc_fee(500);
		ActivityBean.setAc_organizer("主辦");
		ActivityBean.setType(0);
		ActivityService.save(ActivityBean);
		return "redirect:/Backendactivity/activitylist";
	}

	@GetMapping ("/saveActivity2")
	public String saveActivity2(ActivityBean ActivityBean) {
		ActivityBean.setAc_name("家訪志工招募說明會");
		ActivityBean.setLocalFileName("逗貓貓.jpg");
		ActivityBean.setAc_date(Date.valueOf("1989-06-04"));
		ActivityBean.setAc_participant("#家戶訪查 #志工招募 #全面絕育計畫 春天來臨時，也是狗狗們爭先恐後的來到這個世界上的熱門時間！夥伴們總心想：他們會不會好好地長大呢？未來是不是又會有更多狗狗出生在危機滿滿的街頭上呢？✨全面絕育計畫✨透過大規模的地毯式家戶訪查，把有生育可能性的母犬快速找出來，阻止春後的嬰兒潮。如果您喜歡與人溝通，也想要幫助流浪犬，快來加入我們的尋狗之旅吧！");
		ActivityBean.setAc_venue("地點");
		ActivityBean.setAc_quota(50);
		ActivityBean.setAc_waitlist_quota(0);
		ActivityBean.setAc_fee(500);
		ActivityBean.setAc_organizer("主辦");
		ActivityBean.setType(0);
		ActivityService.save(ActivityBean);
		return "redirect:/Backendactivity/activitylist";
	}

	@GetMapping ("/saveActivity3")
	public String saveActivity3(ActivityBean ActivityBean) {
		ActivityBean.setAc_name("台中市動物保護志工招募");
		ActivityBean.setLocalFileName("忠誠狗勾.jpg");
		ActivityBean.setAc_date(Date.valueOf("1911-10-10"));
		ActivityBean.setAc_participant("關心動物保護議題，卻不知如何投入動物保護第一線嗎？台中動保處今年的志工招募活動開跑了!台中的朋友們可別錯過這個機會，服務內容包含推廣動物保護觀念、協助追蹤動保案件，以及照顧、陪伴園區內的犬貓，服務內容為協助動保處進行動物保護宣導活動、動保案件稽查，動物之家園區介紹導覽、照顧園內犬貓、推廣認領養等等。多元的服務內容，能讓大家發揮所長一同為動物盡一份力量！");
		ActivityBean.setAc_venue("地點");
		ActivityBean.setAc_quota(50);
		ActivityBean.setAc_waitlist_quota(0);
		ActivityBean.setAc_fee(500);
		ActivityBean.setAc_organizer("主辦");
		ActivityBean.setType(0);
		ActivityService.save(ActivityBean);
		return "redirect:/Backendactivity/activitylist";
	}

	@GetMapping ("/saveActivity4")
	public String saveActivity4(ActivityBean ActivityBean) {
		ActivityBean.setAc_name("苗栗場下鄉志工招募說明會");
		ActivityBean.setLocalFileName("忠誠狗勾2.jpg");
		ActivityBean.setAc_date(Date.valueOf("1949-10-01"));
		ActivityBean.setAc_participant("成為下鄉志工隊的一員，首先需要先參與協會不定期辦理的下鄉志工招募說明會。在說明會中，我們會與您分享台灣流浪犬貓現況、介紹下鄉絕育行動及下鄉志工的工作。參與過下鄉志工招募說明會後，就可以參加下鄉活動囉！下鄉志工隊有專屬的寶藍色志工服，在參與5場下鄉絕育活動後，再參與1場動保講座暨志工提昇班，就可以獲得寶藍色的下鄉志工志工服，成為正式的下鄉志工！");
		ActivityBean.setAc_venue("地點");
		ActivityBean.setAc_quota(50);
		ActivityBean.setAc_waitlist_quota(0);
		ActivityBean.setAc_fee(500);
		ActivityBean.setAc_organizer("主辦");
		ActivityBean.setType(0);
		ActivityService.save(ActivityBean);
		return "redirect:/Backendactivity/activitylist";
	}

//	@PostMapping("/saveActivity")
//	public String saveActivity(@ModelAttribute("activity") ActivityBean ActivityBean) {
//		System.out.println("getImage: " + (ActivityBean.getImage()==null));
//		Boolean isInsert = (ActivityBean.getAc_id()==null);
//
//		ActivityBean activityBean1 = saveImageInDB(ActivityBean,isInsert);
//		saveImageInLocal(activityBean1, isInsert);
//		ActivityService.save(ActivityBean);
//		return "redirect:/activitylist";
//	}


	@RequestMapping("/apShowForm/{ac_id}")
	public ModelAndView apshowFormForAdd(@PathVariable long ac_id) {
		ModelAndView mav = new ModelAndView("Backendactivity/activityNewAPForm");//指向activityEditForm.html
		ActivityBean ActivityBean = ActivityService.FindById(ac_id);
		mav.addObject("activity", ActivityBean);

		return mav;
	}
	@GetMapping("/updateacForm/{ac_id}")
	public ModelAndView showFormForUpdate(@PathVariable long ac_id){
		ModelAndView mav = new ModelAndView("Backendactivity/activityEditForm");//指向activityEditForm.html
		ActivityBean ActivityBean = ActivityService.FindById(ac_id);
		mav.addObject("activity", ActivityBean);

		return mav;
	}
	
	@GetMapping("/deleteac/{ac_id}")
	public String deleteActivity(@PathVariable long ac_id) {
		ActivityService.delete(ac_id);
		return "redirect:/Backendactivity/activitylist";
	}
	@GetMapping("/deleteap/{orderNo}")
	public String deleteAP(@PathVariable long orderNo) {
		ActivityService.deleteAP(orderNo);
		return "redirect:/Frontendactivity/APlist";
	}

	// 讓「查詢頁面」可以取得db中的BLOB圖片欄
		@GetMapping("/acpicture/{ac_id}")
		public ResponseEntity<byte[]> getPicture(@PathVariable("ac_id") Integer ac_id) {
			byte[] body = null;
			ResponseEntity<byte[]> responseEntity = null;
			MediaType mediaType = null;
			HttpHeaders headers = new HttpHeaders();
			headers.setCacheControl(CacheControl.noCache().getHeaderValue());
			ActivityBean activity = ActivityService.FindById(ac_id);

			// 沒有會員資料
			if(activity == null) {
				return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
			}else {
			// 有會員資料
				String LocalFileName = activity.getLocalFileName();
				// 有local檔名 -> 因為csv直接匯入 || 有新增照片
				if(LocalFileName != null) {
					// 設定ResponseHeaders
					/* 透過檔名 setContentType(MediaType) */
					if (LocalFileName.toLowerCase().endsWith("jfif")) {
						mediaType = MediaType.valueOf(ctx.getMimeType("dummy.jpeg"));
					} else {
						mediaType = MediaType.valueOf(ctx.getMimeType(LocalFileName));
						headers.setContentType(mediaType);
					}
					// 設定ResponseBody
//					body = fileToByteArray("/resources/images/activity/" + LocalFileName);
					body = fileToByteArray("/resources/images/activityImage/" + LocalFileName);
				}else {
				//沒有local檔名 -> 新增不傳圖片 -> 所以要顯示預設圖片
					body = fileToByteArray("/resources/images/memberHeadshot/defaultHeadshot.jpg");  //如果圖片為空，就上傳預設圖片
				}
				responseEntity = new ResponseEntity<byte[]>(body, headers, HttpStatus.OK);
				return responseEntity;
			}
		}
			


		private byte[] fileToByteArray(String path) {
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
	
//MultipartFile 轉 BLOB型態 ，塞進DB
//	public ActivityBean saveImageInDB(ActivityBean ActivityBean, Boolean isInsert) {
//		MultipartFile picture = ActivityBean.getProductImage(); //取得MultipartFile檔案
//		// setImage (建立Blob物件，交由 Hibernate 寫入資料庫)
//		if (picture != null && !picture.isEmpty()) {
//			// 如果有上傳照片
//			try {
//				byte[] b = picture.getBytes();
//				Blob blob = new SerialBlob(b);
//				ActivityBean.setImage(blob);   //塞BLOB
//				return ActivityBean;
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
//			}
//		}else {
//			// 如果沒有上傳照片
//			if( !isInsert ) { // 是update時
//				try {
//					ActivityBean.setImage(ActivityService.FindById(ActivityBean.getAc_id()).getImage());  // 找DB中的舊照片
//					System.out.println("setImaget 成功");
//					return ActivityBean;
//				} catch (Exception e) {
//					e.printStackTrace();
//					throw new RuntimeException("修改時 檔案上傳發生異常: " + e.getMessage());
//				}
//			} // 不是update時不用setImage
//			return ActivityBean;
//		}
//	}

	// 把圖片塞到本機(放在此專案下)
		public void saveImageInLocal(ActivityBean activityBean, Boolean isInsert)	{
			String contextPath = ctx.getRealPath("");
			String savePath = contextPath + imageLocation /* + File.separator*/;
//			String savePath = contextPath + uploadDir /* + File.separator*/;
			System.out.println("savePath: " + savePath);
			// 建立資料夾
			File fileSaveDir = new File(savePath); //Server端的站存資料夾 -> D:\1_iSpan\_TeamWork\teamWorkSpace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Lung-springmvc\resource\images\activityImage
			if (!fileSaveDir.exists()) {fileSaveDir.mkdir(); /*如果沒有這個資料夾，就建立資料夾*/  }
			// 把圖片存到本機資料夾
			String filename = null;
			MultipartFile picture = activityBean.getProductImage();
			// 如果有取得MultipartFile(有上傳照片)
			if (picture != null && !picture.isEmpty()) {
				// setLocalfileName( ) && 存圖片到本機
				// 不管是insert 或 update都要執行
				try {
					filename =  System.currentTimeMillis() + "_" + picture.getOriginalFilename();  //串接檔名 -> 毫秒_原始檔名
					File saveFile = new File(fileSaveDir, filename);
					picture.transferTo(saveFile);  // 存到硬碟
					activityBean.setLocalFileName(filename);
					System.out.println("LocalfileName:" + filename);
					System.out.println("照片存到本機專案下 -> 成功");		
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("修改時 照片存到本機有問題");
				}
				// 是update時
				if( !isInsert ) {
					try {
						// 刪除本機舊照片
						deleteImageInLocal(activityBean);
					} catch (Exception e) {
						System.out.println("修改時 刪除本機照片有問題");
					}
				}		
			}else {
			// 如果沒有取得MultipartFile(沒有上傳照片)
				if( !isInsert ) {
					// 是update時
					try {
						activityBean.setLocalFileName(ActivityService.FindById(activityBean.getAc_id()).getLocalFileName());
						System.out.println("setLocalfileName 成功");
					} catch (Exception e) {
						e.printStackTrace();
						throw new RuntimeException("修改時 setLocalfileName()發生異常: " + e.getMessage());
					}
				}else {
					// 不是update時不用setLocalfileName
					System.out.println("==========離開 saveHeadshotInLocal()==========");
				}
			}
		 }



		public void deleteImageInLocal(ActivityBean activity) {
			String contextPath = ctx.getRealPath("");
			String filePath = contextPath + imageLocation + File.separator;
			System.out.println("filePath: " + filePath);
			
			String oldFilenameString = ActivityService.FindById(activity.getAc_id()).getLocalFileName();  //找到本地的舊檔名
			System.out.println("oldFilenameString:" + oldFilenameString);
			try {
				File file = new File(filePath + oldFilenameString);
				file.delete();
				System.out.println("本地圖片檔已被刪除");
				System.out.println("刪除的檔名為: " + oldFilenameString);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("刪除檔案有錯");
			}
		}
}