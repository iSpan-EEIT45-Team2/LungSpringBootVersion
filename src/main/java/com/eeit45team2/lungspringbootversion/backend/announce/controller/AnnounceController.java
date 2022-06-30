package com.eeit45team2.lungspringbootversion.backend.announce.controller;

import com.eeit45team2.lungspringbootversion.backend.announce.model.AnnounceBean;
import com.eeit45team2.lungspringbootversion.backend.announce.service.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/Backendannounce")
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
		return "redirect:/Backendannounce/announcelist";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("announceID") Long anNO, Model model) {
		AnnounceBean announceBean = announceService.FindById(anNO);
		model.addAttribute("order", announceBean);
		return "Backendannounce/announceEditForm";
	}
	
	@GetMapping("/delete")
	public String deleteAnnounce(@RequestParam("announceID") Long anNO) {
		announceService.delete(anNO);
		return "redirect:/Backendannounce/announcelist";
	}
}
