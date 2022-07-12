//package com.eeit45team2.lungspringbootversion.backend.order.controller;
//
//import com.eeit45team2.lungspringbootversion.backend.order.model.OrderBean;
//import com.eeit45team2.lungspringbootversion.backend.order.service.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/Backendorder")
//public class OrderController {
//
//    @Autowired
//    private OrderService orderService;
//
//    @RequestMapping("/orderlist")
//    public String listOrders(Model model) {
//        List<OrderBean> orderBeans = orderService.findAll();
//        model.addAttribute("orders", orderBeans);
//        return "Backendorder/BackOrder";
//    }
//
//    @RequestMapping("/showForm")
//    public String showFormForAdd(Model model) {
//        OrderBean orderBean = new OrderBean();
//        model.addAttribute("order", orderBean);
//        return "Backendorder/orderNewForm";
//    }
//
//
//    @PostMapping("/saveOrder")
//    public String saveOrder(@ModelAttribute("order") OrderBean orderBean) {
//        orderService.save(orderBean);
//        return "redirect:/Backendorder/orderlist";
//    }
//
//    @GetMapping("/updateForm/{od_id}")
//    public ModelAndView showFormForUpdate(@PathVariable Long od_id) {
//        ModelAndView mav = new ModelAndView("Backendorder/orderEditForm");//指向orderEditForm.html
//        OrderBean orderBean = orderService.FindById(od_id);
//        mav.addObject("order", orderBean);
//        return mav;
//    }
//
//    @GetMapping(value = "/delete/{od_id}")
//    public String deleteOrder(@PathVariable Long od_id) {
//        orderService.delete(od_id);
//        return "redirect:/Backendorder/orderlist";
//    }
//}
