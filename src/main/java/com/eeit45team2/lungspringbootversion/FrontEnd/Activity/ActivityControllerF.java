package com.eeit45team2.lungspringbootversion.FrontEnd.Activity;

import com.eeit45team2.lungspringbootversion.backend.activity.model.AcApplyBean;
import com.eeit45team2.lungspringbootversion.backend.activity.model.ActivityBean;
import com.eeit45team2.lungspringbootversion.backend.activity.service.ActivityService;
import com.eeit45team2.lungspringbootversion.backend.animal.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.security.Principal;

@Controller
@RequestMapping("/Frontendactivity")
public class ActivityControllerF {
    @Autowired
    private ActivityService activityService;

    @Autowired
    private JavaMailSender mailSender;

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
//    @GetMapping("/activitydetails/{ac_id}")
//    public ModelAndView Update(@PathVariable Long ac_id) {
//        ModelAndView mav = new ModelAndView("FrontEnd/Activity/activitydetails");
//        ActivityBean activityBean = activityService.FindById(ac_id);
//        mav.addObject("activities", activityBean);
//        return mav;
//
//    }
    @GetMapping("/activitydetails/{ac_id}")
    public ModelAndView Update(@PathVariable Long ac_id) {
        ModelAndView mav = new ModelAndView("FrontEnd/Activity/activitydetails");
        ActivityBean activityBean = activityService.FindById(ac_id);
        mav.addObject("activities", activityBean);
        return mav;

    }
    @PostMapping("/saveAcApply")
    public RedirectView AbDogSave(AcApplyBean abdogbean,
                                  @RequestParam("image") MultipartFile multipartFile) throws IOException {
        SimpleMailMessage message = new SimpleMailMessage();
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        abdogbean.setAbphonto(fileName);
        activityService.saveapply(abdogbean);
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
        return new RedirectView("/Backendanimal/abdoglist", true);

    }
    @RequestMapping("/activityForm")
    public String showFormForAdd(Model model, Principal principal) {
        AcApplyBean abdogbean = new AcApplyBean();
        if (principal != null) {
            principal.getName();
            System.out.println("--------------------------");
            System.out.println("目前登入是: " + principal.getName());
            model.addAttribute("animals", abdogbean);
            return "/FrontEnd/Activity/acapply-save";
        } else {
            return "login";
        }
    }

}