package com.eeit45team2.lungspringbootversion.FrontEnd.Activity;

import com.eeit45team2.lungspringbootversion.backend.activity.model.ActivityBean;
import com.eeit45team2.lungspringbootversion.backend.activity.service.ActivityService;
import com.eeit45team2.lungspringbootversion.backend.animal.model.AbDogBean;
import com.eeit45team2.lungspringbootversion.backend.animal.repository.AbDogRepository;
import com.eeit45team2.lungspringbootversion.backend.animal.service.AbDogService;
import com.eeit45team2.lungspringbootversion.backend.animal.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

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

//    {
//        @Autowired
//        private AbDogService abDogService;
//        @Autowired
//        private AbDogRepository abdogRepository;
//        @Autowired
//        private JavaMailSender mailSender;
//        @GetMapping("/animals")
//        public String showAnimal(Model model, @Param("keyword") String keyword ) {
//        List<AbDogBean> abdogbeans = abDogService.abdoglistAll(keyword);
//        model.addAttribute("animals", abdogbeans);
//        model.addAttribute("keyword", keyword);
////        if (principal != null) {
////            principal.getName();
////            System.out.println("--------------------------");
////            System.out.println("沈77: " + principal.getName());
//        return "FrontEnd/Animal/anblog";
////        } else {
////            return "login";
////        }
//    }
//
//        @RequestMapping("/animal1")
//        public String showAnimal1(Model model, Principal principal, @Param("keyword") String keyword ) {
//        String key = principal.getName();
//        List<AbDogBean> animal1 = abDogService.abdoglistAll(key);
//        model.addAttribute("keyword", keyword);
//        model.addAttribute("animal1", animal1);
//        if (principal != null) {
//            principal.getName();
//            System.out.println("--------------------------");
//            System.out.println("沈77: " + principal.getName());
//
//            return "/FrontEnd/Animal/anaaa1";
//        } else {
//            return "login";
//        }
//
//
//
//    }
//
//        @RequestMapping("/animalForm")
//        public String showFormForAdd(Model model,Principal principal) {
//        AbDogBean abdogbean = new AbDogBean();
//        if (principal != null) {
//            principal.getName();
//            System.out.println("--------------------------");
//            System.out.println("目前登入是: " + principal.getName());
//            model.addAttribute("animals", abdogbean);
//            return "/FrontEnd/Animal/anblog-save";
//        } else {
//            return "login";
//        }
//    }
//
//        @PostMapping("/saveAnimal")
//        public RedirectView AbDogSave(AbDogBean abdogbean,
//            @RequestParam("image") MultipartFile multipartFile) throws IOException {
//        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//        SimpleMailMessage message = new SimpleMailMessage();
//
//        abdogbean.setAbphonto(fileName);
//        abDogService.save(abdogbean);
//        //String uploadDir = "./user-photos/" +book.getId();./是當前目錄/user-photos/book.getId()
//        //   String uploadDir = "./user-photos/"  ;// ./是當前目錄/user-photos
//        String uploadDir = "./src/main/resources/static/BackEnd/images/animal/";
//        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
//        message.setFrom("Lunghipeace0302@gmail.com");
//        message.setTo(abdogbean.getAbemail());
//        message.setSubject("謝謝您的來信");
//        message.setText("目前表單正在審核中");
//        mailSender.send(message);
//        System.out.println("Mail Sent succesfully...");
//
//        return new RedirectView("/animals", true);
//    }
//
//
        @GetMapping("/activitydetails/{ac_id}")
        public ModelAndView Update(@PathVariable Long ac_id) {
        ModelAndView mav = new ModelAndView("FrontEnd/Activity/ACshop-details");
        ActivityBean activityBean = activityService.FindById(ac_id);
        mav.addObject("activities", activityBean);
        return mav;

    }
//
//
//
//    }

}