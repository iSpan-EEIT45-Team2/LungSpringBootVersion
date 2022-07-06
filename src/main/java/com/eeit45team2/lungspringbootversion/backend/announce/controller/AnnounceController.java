package com.eeit45team2.lungspringbootversion.backend.announce.controller;

import com.eeit45team2.lungspringbootversion.backend.animal.model.AdDogBean;
import com.eeit45team2.lungspringbootversion.backend.announce.model.AnnounceBean;
import com.eeit45team2.lungspringbootversion.backend.announce.service.AnnounceService;
import com.eeit45team2.lungspringbootversion.backend.order.model.OrderBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//RequestMapping("/Backendannounce")
public class AnnounceController {

	@Autowired
	private AnnounceService announceService;

	@GetMapping("/announcelist")
	public String listAnnounce(Model model) {
		List<AnnounceBean> announceBeans = announceService.findAll();
		model.addAttribute("announces", announceBeans);
		return "/Backendannounce/announce";
	}

	@RequestMapping("/showForm")
	public String showFormForAdd(Model model) {
		AnnounceBean announceBean = new AnnounceBean();
		model.addAttribute("announce", announceBean);
		return "/Backendannounce/announceNewForm";
	}


	@PostMapping("/saveAnnounce")
	public String saveAnnounce(@ModelAttribute("announce") AnnounceBean announceBean) {
		announceService.save(announceBean);
		return "redirect:/announcelist";
	}

	@GetMapping("/updateForm/{anNO}")
	public ModelAndView showFormForUpdate(@PathVariable Long anNO) {
		ModelAndView mav1 = new ModelAndView("Backendannounce/announceEditForm");
		AnnounceBean announceBean = announceService.FindById(anNO);
		mav1.addObject("announce",announceBean);
		return mav1;
	}

	@GetMapping(value = "/delete/{anNO}")
	public String deleteAnnounce(@PathVariable Long anNO) {
		announceService.delete(anNO);
		return "redirect:/announcelist";
	}
}





