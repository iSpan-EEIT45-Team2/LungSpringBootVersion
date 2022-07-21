package com.eeit45team2.lungspringbootversion.FrontEnd.Activity;

import com.eeit45team2.lungspringbootversion.backend.activity.model.ActivityBean;
import com.eeit45team2.lungspringbootversion.backend.activity.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Frontendactivity")
public class ActivityControllerF {
    @Autowired
    private ActivityService activityService;


    //顯示商品
//    @GetMapping("/activities")
//    public ModelAndView getAllProducts() {
//        ModelAndView modelAndView = new ModelAndView("/FrontEnd/Activity/ACshop"); //對應的html檔路徑
//        modelAndView.addObject("activities", activityService.findAll());
////        modelAndView.addObject("products", productService.findAll());
//        return modelAndView;
//    }

    @GetMapping("/activities")
    public String showActivities(Model model) {
        model.addAttribute("activities", activityService.findAll());
//        return "FrontEnd/Activity/blog";
        return "FrontEnd/Activity/ACshop";
    }
    @GetMapping("/activitydetails/{ac_id}")
    public ModelAndView Update(@PathVariable Long ac_id) {
        ModelAndView mav = new ModelAndView("FrontEnd/Activity/activitydetails");
        ActivityBean activityBean = activityService.FindById(ac_id);
        mav.addObject("activities", activityBean);
        return mav;

    }

}