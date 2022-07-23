package com.eeit45team2.lungspringbootversion.FrontEnd.Activity;

import com.eeit45team2.lungspringbootversion.backend.activity.model.AcApplyBean;
import com.eeit45team2.lungspringbootversion.backend.activity.model.ActivityApply;
import com.eeit45team2.lungspringbootversion.backend.activity.model.ActivityBean;
import com.eeit45team2.lungspringbootversion.backend.activity.service.ActivityApplyService;
import com.eeit45team2.lungspringbootversion.backend.activity.service.ActivityService;
import com.eeit45team2.lungspringbootversion.backend.animal.util.FileUploadUtil;
import com.eeit45team2.lungspringbootversion.backend.member.model.MemberBean;
import com.eeit45team2.lungspringbootversion.backend.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/Frontendactivity")
public class ActivityControllerF {
    @Autowired
    private ActivityService activityService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ActivityApplyService orderService;

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
//    @PostMapping("/CheckOutApply/{ac_id}")
//    public ModelAndView viewCheckOut(@PathVariable Long ac_id,
//                                     Model model, Principal principal) {
//        if (principal == null) {
////            return "redirect:/login";
//            ModelAndView mav = new ModelAndView("login");
//            return mav;
//
//        }
//        ModelAndView mav = new ModelAndView("FrontEnd/Activity/CheckOutApply");
//        ActivityBean activityBean = activityService.FindById(ac_id);
//        System.out.println("活動號碼="+ac_id);
//        mav.addObject("activities", activityBean);
//        MemberBean memberBean = memberService.findByMiAccount(principal.getName());
//        System.out.println("帳號名稱是" + memberBean);
//
//        return mav;
//    }
    @GetMapping("CheckOutApply/{ac_id}")
    public String viewCheckOut(@PathVariable Long ac_id,
                               Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }
        ActivityBean activityBean = activityService.FindById(ac_id);
        System.out.println("活動號碼="+ac_id);
        MemberBean memberBean = memberService.findByMiAccount(principal.getName());
        System.out.println("帳號名稱是" + memberBean);
        model.addAttribute("ACNAME",activityBean.getAc_name());
        model.addAttribute("ACDATE",activityBean.getAc_date());
        model.addAttribute("ACVENUE",activityBean.getAc_venue());
        model.addAttribute("ACID",activityBean.getAc_id());
        model.addAttribute("ACOR",activityBean.getAc_organizer());
        model.addAttribute("ACIMG",activityBean.getLocalFileName());
        model.addAttribute("MiCity", memberBean.getMiCity());
        model.addAttribute("MiDistrict", memberBean.getMiDistrict());
        model.addAttribute("MiAddress", memberBean.getMiAddress());
        model.addAttribute("MiName", memberBean.getMiName());
        model.addAttribute("MiPhone", memberBean.getMiPhone());
        model.addAttribute("MiEmail", memberBean.getMiEmail());
        return "FrontEnd/Activity/CheckOutApply";
    }
//    @GetMapping("CheckOutApply")
//    public String viewCheckOut(@ModelAttribute("cart") ActivityBean cart,
//                               Model model, Principal principal) {
//        if (principal == null) {
//            return "redirect:/login";
//        }
//        System.out.println("活動ID : "+cart.getAc_id());
//        MemberBean memberBean = memberService.findByMiAccount(principal.getName());
//        model.addAttribute("MiCity", memberBean.getMiCity());
//        model.addAttribute("MiDistrict", memberBean.getMiDistrict());
//        model.addAttribute("MiAddress", memberBean.getMiAddress());
//        model.addAttribute("MiName", memberBean.getMiName());
//        model.addAttribute("MiPhone", memberBean.getMiPhone());
//        model.addAttribute("MiEmail", memberBean.getMiEmail());
//        return "FrontEnd/Activity/CheckOutApply";
//    }


    @PostMapping(path = "/saveActivityApply")
    public String checkOut(@ModelAttribute ActivityBean cart,
                                           @RequestParam String address,
                                           @RequestParam String name,
                                           @RequestParam Integer phone,
                                           @RequestParam String acname,
                                           @RequestParam String acdate,
                                           @RequestParam String acvenue,
                                           @RequestParam String acor,
                                           @RequestParam String email,
                                           @RequestParam Integer acid,
//                                           @RequestParam PayType payType,
                                           HttpServletRequest request,
                                           SessionStatus status,
                                           Principal principal,
                           ActivityApply activityApply){
//        if(principal==null){
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//        String baseURL = request.getRequestURL().substring(0, request.getRequestURL().length() - request.getRequestURI().length()) + request.getContextPath();
        String orderNo = null;

        if(cart != null){
            ActivityApply order = new ActivityApply();
            //訂單編號
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            Date current = new Date();
            int end = (int) (Math.random() * 20);
            order.setOrderNo(df.format(current) + end);
            orderNo = order.getOrderNo();
            order.setOrderDate(current);
            //狀態
//            order.setApplyStatus(ApplyStatus.WAIT_PAYMENT);
//            order.setPayType(payType);
            MemberBean memberBean = memberService.findByMiAccount(principal.getName());
            order.setMemberBean(memberBean);
            order.setAddress(address);
            order.setName(name);
            order.setPhone(phone);
            order.setAcdate(acdate);
            order.setAcid(acid);
            order.setAcvenue(acvenue);
            order.setAcname(acname);
            order.setAcor(acor);
//            order.setOrderItems(new LinkedHashSet<>(cart.getCart().values()));
            //寄送活動申請信
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("Lunghipeace0302@gmail.com");
            System.out.println(email);
            message.setTo(email);
            message.setSubject("謝謝您的來信");
            message.setText("目前表單正在審核中");
            mailSender.send(message);
            System.out.println("Mail Sent succesfully...");

//            order.getOrderItems().forEach((e) -> e.setOrder(order));
//            order.setTotalPrice(cart.getTotal());
            orderService.createOrder(order);
//            status.setComplete();
        }

//        return "FrontEnd/Activity/ACshop";
        return "redirect:/Frontendactivity/activities";
//        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(baseURL + "/Order/" + orderNo + "/Pay")).build();
    }
}