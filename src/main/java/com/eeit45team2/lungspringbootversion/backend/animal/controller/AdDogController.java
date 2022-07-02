package com.eeit45team2.lungspringbootversion.backend.animal.controller;

import com.eeit45team2.lungspringbootversion.backend.animal.model.AbDogBean;
import com.eeit45team2.lungspringbootversion.backend.animal.model.AdDogBean;
import com.eeit45team2.lungspringbootversion.backend.animal.service.AbDogService;
import com.eeit45team2.lungspringbootversion.backend.animal.service.AdDogService;
import com.eeit45team2.lungspringbootversion.backend.animal.util.FileUploadUtil;
import com.eeit45team2.lungspringbootversion.backend.order.model.OrderBean;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AdDogController {

	@Autowired
	private AdDogService addogService;
	//自動實現

	@GetMapping("addoglist")
	public String listaddogs(Model model) {//call service撈資料 >連API>listall
		List <AdDogBean> addogbeans = addogService.addoglistAll();
		model.addAttribute("addogs", addogbeans);
		return "/BackendAnimal/BackAdDog";
		//真實程式 非虛擬路徑
	}
	@RequestMapping("/adshowForm")
	public String showFormForAdd(Model model) {
		AdDogBean addogbean = new AdDogBean();
		model.addAttribute("addog", addogbean);
		return "/BackendAnimal/addogNewForm";
	}

	@PostMapping("/saveAdDog")
	public String saveAdDog(@ModelAttribute("addog") AdDogBean addogbean) {
	 	addogService.save(addogbean);
		return "redirect:/addoglist";
	}




	@GetMapping(value = "/addelete/{adid}")
		public String deleteaddog(@PathVariable Long adid) {
			addogService.delete(adid);
			return "redirect:/addoglist";
		}

	@GetMapping("/adupdateForm/{adid}")
	public ModelAndView adUpdate(@PathVariable Long adid) {
		ModelAndView mav = new ModelAndView("BackendAnimal/addogEditForm");//指向orderEditForm.html
		AdDogBean adDogBean = addogService.get(adid);
		mav.addObject("addog", adDogBean);
		return mav;
	}

	    }

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