package com.eeit45team2.lungspringbootversion.backend.animal.controller;

import com.eeit45team2.lungspringbootversion.backend.animal.model.AbDogBean;
import com.eeit45team2.lungspringbootversion.backend.animal.service.AbDogService;
import com.eeit45team2.lungspringbootversion.backend.animal.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;

@Controller
public class AbDogController {

	@Autowired
	private AbDogService abdogService;
	//自動實現

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
	@GetMapping("abdoglist")
	public String listabdogs(Model model) {//call service撈資料 >連API>listall
		List <AbDogBean> abdogbeans = abdogService.abdoglistAll();
		model.addAttribute("abdogs", abdogbeans);
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
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		abdogbean.setAbphonto(fileName);
		abdogService.save(abdogbean);
		//String uploadDir = "./user-photos/" +book.getId();./是當前目錄/user-photos/book.getId()
		//   String uploadDir = "./user-photos/"  ;// ./是當前目錄/user-photos
		String uploadDir = "./src/main/resources/static/BackEnd/images/animal/"  ;
		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
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

	    }

	
	

	
	
	

	
