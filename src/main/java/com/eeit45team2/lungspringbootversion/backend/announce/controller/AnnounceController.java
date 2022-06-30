package com.eeit45team2.lungspringbootversion.backend.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eeit45team2.lungspringbootversion.backend.order.model.OrderBean;
import com.eeit45team2.lungspringbootversion.backend.order.service.OrderService;

@Controller
//@RequestMapping("/Backendorder")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/orderlist")
	public String listOrders(Model model) {
		List<OrderBean> orderBeans = orderService.findAll();
		model.addAttribute("orders", orderBeans);
		return "/Backendorder/BackOrder";
	}

	@RequestMapping("/showForm")
	public String showFormForAdd(Model model) {
		OrderBean orderBean = new OrderBean();
		model.addAttribute("order", orderBean);
		return "/Backendorder/orderNewForm";
	}


	@PostMapping("/saveOrder")
	public String saveOrder(@ModelAttribute("order") OrderBean orderBean) {
		orderService.save(orderBean);
		return "redirect:/Backendorder/orderlist";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("orderID") Long od_id, Model model) {
		OrderBean orderBean = orderService.FindById(od_id);
		model.addAttribute("order", orderBean);
		return "Backendorder/orderEditForm";
	}
	
	@GetMapping("/delete")
	public String deleteOrder(@RequestParam("orderID") Long od_id) {
		orderService.delete(od_id);
		return "redirect:/Backendorder/orderlist";
	}
}
