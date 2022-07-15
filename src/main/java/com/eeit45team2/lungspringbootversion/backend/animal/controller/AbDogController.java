package com.eeit45team2.lungspringbootversion.backend.animal.controller;

import com.eeit45team2.lungspringbootversion.backend.animal.json.JsonExporter;
import com.eeit45team2.lungspringbootversion.backend.animal.model.AbDogBean;
import com.eeit45team2.lungspringbootversion.backend.animal.repository.AbDogRepository;
import com.eeit45team2.lungspringbootversion.backend.animal.service.AbDogService;
import com.eeit45team2.lungspringbootversion.backend.animal.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

@Controller
@RequestMapping("/BackendAbdog")
public class AbDogController {
//	@Autowired
//	private EmailSenderService senderService;

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private AbDogService abdogService;
	//自動實現
	@Autowired

	private AbDogRepository abdogRepository;
	@Autowired
	private JsonExporter jsonExporter;

//	 @RequestMapping("/abdoglist")//映照path url
//		public String viewHomePage(Model model) {  //Modelo儲存
//		return viewPage(model, 1);// 連動viewPage()方法 引數 1
//	}

//	@RequestMapping("/page/{pageNum}") //映照path url
//	public String viewPage(Model model,
//						   @PathVariable(name = "pageNum") int pageNum) {
//		//取得前頁面參數頁碼  @PathVariable頁面可動參數
//		Page<AbDogBean> page = abdogService.listAll(pageNum);//link service reposity
//		//Page 函數Page是一個子接口它知道表中的總頁數以及記錄總數。
//
//		List<AbDogBean> abdogbeans = page.getContent();//記錄資料
//
//		model.addAttribute("currentPage", pageNum);//現在頁
//		model.addAttribute("totalPages", page.getTotalPages());//總頁數
//		model.addAttribute("totalItems", page.getTotalElements());//記錄總數
//		model.addAttribute("abdogs", abdogbeans);
//		//共回傳 四個參數  currentPage現在頁,/總頁數totalPages/記錄總數totalItems//  資料"listbooks"
//		return "/BackendAnimal/BackAbDog";
//	}

	@GetMapping("showjs")
	public String showjs1(Model model) {//call service撈資料 >連API>listall

		return "/BackendAnimal/abchartjs";
		//真實程式 非虛擬路徑
	}

	@GetMapping("abdoglist")
	public String listabdogs(Model model, @Param("keyword") String keyword) {//call service撈資料 >連API>listall
		List<AbDogBean> abdogbeans = abdogService.abdoglistAll(keyword);
		model.addAttribute("abdogs", abdogbeans);
		model.addAttribute("keyword", keyword);

		return "/BackendAnimal/BackAbDog";
		//真實程式 非虛擬路徑
	}


	@RequestMapping("/abshowForm")
	public String showFormForAdd(Model model) {
		AbDogBean abdogbean = new AbDogBean();
		model.addAttribute("abdog", abdogbean);
		return "/BackendAnimal/abdogNewForm";
	}

	@PostMapping("/saveAbDog")
	public RedirectView AbDogSave(AbDogBean abdogbean,
								  @RequestParam("image") MultipartFile multipartFile) throws IOException {
		SimpleMailMessage message = new SimpleMailMessage();

		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		abdogbean.setAbphonto(fileName);
		abdogService.save(abdogbean);
		//String uploadDir = "./user-photos/" +book.getId();./是當前目錄/user-photos/book.getId()
		//   String uploadDir = "./user-photos/"  ;// ./是當前目錄/user-photos
		String uploadDir = "./src/main/resources/static/BackEnd/images/animal/";
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		message.setFrom("Lunghipeace0302@gmail.com");
		message.setTo(abdogbean.getAbemail());
		message.setSubject("謝謝您的來信");
		message.setText("目前表單正在審核中");
		mailSender.send(message);
		System.out.println("Mail Sent succesfully...");
		return new RedirectView("/abdoglist", true);

	}


	@GetMapping(value = "/abdelete/{abid}")
	public String deleteabdog(@PathVariable Long abid) {
		abdogService.delete(abid);
		return "redirect:/abdoglist";
	}


	@GetMapping("/abupdateForm/{abid}")
	public ModelAndView abUpdate(@PathVariable Long abid) {
		ModelAndView mav = new ModelAndView("BackendAnimal/abdogEditForm");//指向orderEditForm.html
		AbDogBean abDogBean = abdogService.get(abid);
		mav.addObject("abdog", abDogBean);
		return mav;
	}


	@RequestMapping("/pass/{id}")
	public String pass(@PathVariable(name = "id") int abid) {
		AbDogBean abDogBean = abdogService.get(abid);
		abDogBean.setAbaudit(0);
		abdogService.save(abDogBean);
		return "redirect:/abdoglist";
	}


	@RequestMapping(value = "/down", produces = "application/json;charset=UTF-8")
	//  @GetMapping("/down"     )
	public ResponseEntity<byte[]> downloadJsonFile() {
		List<AbDogBean> abdogbeans = (List<AbDogBean>) abdogRepository.findAll();
		String abdogJsonString = jsonExporter.export(abdogbeans);
		//byte[] productJsonBytes = productJsonString.getBytes();
		byte[] abdogJsonBytes = abdogJsonString.getBytes(Charset.forName("utf-8"));
		//(json.getBytes(Charset.forName("GBK"))); //將json資料寫入流中
		return ResponseEntity
				.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=customers.json")
				.contentType(MediaType.APPLICATION_JSON)
				.contentLength(abdogJsonBytes.length)
				.body(abdogJsonBytes);
	}



}


