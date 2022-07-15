package com.eeit45team2.lungspringbootversion.FrontEnd.member;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eeit45team2.lungspringbootversion.backend.member.model.ConfirmationToken;
import com.eeit45team2.lungspringbootversion.backend.member.model.MemberBean;
import com.eeit45team2.lungspringbootversion.backend.member.repository.ConfirmationTokenRepository;
import com.eeit45team2.lungspringbootversion.backend.member.repository.UserRepository;
import com.eeit45team2.lungspringbootversion.backend.member.service.MemberService;
import com.eeit45team2.lungspringbootversion.backend.member.service.impl.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Front")
public class MemberControllerF {

    @Autowired
    private MemberService memberService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailSenderService emailSenderService;



    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView displayRegistration(ModelAndView modelAndView, MemberBean member) {
        modelAndView.addObject("member", member);
        modelAndView.setViewName("/FrontEnd/register");
        return modelAndView;
    }


    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ModelAndView registerUser(ModelAndView modelAndView, MemberBean member) {
//        MemberBean existingUser = userRepository.findByMiEmailIgnoreCase(member.getMiEmail());
//        if(existingUser != null) {
//            modelAndView.addObject("message","This email already exists!");
//            modelAndView.setViewName("error");
//        }
//        else
//        {
        userRepository.save(member);

        ConfirmationToken confirmationToken = new ConfirmationToken(member);

        confirmationTokenRepository.save(confirmationToken);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(member.getMiEmail());
        mailMessage.setSubject("LungHi Peace浪孩和平Email認證信");
        mailMessage.setFrom("LungHiPeace0302@gmail.com");
        mailMessage.setText("您好： 請點選以下連結驗證您的電子郵件信箱。 "
                + "http://localhost:8080/Lung/Front/confirm-account?token=" + confirmationToken.getConfirmationToken());

        emailSenderService.sendEmail(mailMessage);

        modelAndView.addObject("miEmail", member.getMiEmail());

        modelAndView.setViewName("/FrontEnd/registerconfirm");
//    }

        return modelAndView;
    }


    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token")String confirmationToken)
    {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if(token != null)
        {
            MemberBean member = userRepository.findByMiEmailIgnoreCase(token.getMember().getMiEmail());
            member.setMiActive("Y");
            member.setMiRole("USER;ACTIVE");
            userRepository.save(member);
            modelAndView.setViewName("/FrontEnd/registerVerifySuccess");
        }
        else
        {
            modelAndView.addObject("message","連結已失效，請重新驗證。");
            modelAndView.setViewName("/FrontEnd/registerVerifyFailed");
        }

        return modelAndView;
    }



    @PostMapping(value = "/CheckMemberEmail", produces = { "application/json" })
    public @ResponseBody Map<String, Boolean> existsByMiEmail(@RequestBody String res) {
        JSONObject object= JSON.parseObject(res);
        String emailToCheck = (String) object.get("emailToCheck");
        Long miNo;
        if(object.get("miNo") == null){
            miNo = null;
        } else {
            miNo = Long.parseLong((String) object.get("miNo"));
        }

        Map<String, Boolean> map = new HashMap<>();  // 塞訊息的map
        MemberBean memberExisted = userRepository.findByMiEmailIgnoreCase(emailToCheck);
        boolean emailExisted;
        if(memberExisted == null){
            emailExisted = false;
        }else{
            emailExisted = true;
        }

        if(miNo ==null){  // 新增
            // email存在(true)的相反 -> false , email不存在(false)的相反 -> true
            map.put("emailCanUse", !emailExisted);
        }else{  // 修改
            MemberBean member = memberService.findById(miNo); // 從db抓這筆會員的舊email
            // user沒有修改email ->　user現在輸入的email 是否和db中自己的email一樣
            if(member.getMiEmail().equals(emailToCheck)){
                //不塞錯誤訊息(不提示帳號重複)
                map.put("emailCanUse", true);
            }else {
                // user有修改帳號
                map.put("emailCanUse", !emailExisted);
            }
        }
        return map;
    }



    @GetMapping("/registerpage")
    public String showRegisterPage(Model model) {
        MemberBean memberBean = new MemberBean();
        model.addAttribute("member", memberBean);
        return "FrontEnd/register";
    }


    @PostMapping(value ="/registerMember")  // 新增或更新
    public String registerMember(@ModelAttribute("member") MemberBean memberBean) {
        Boolean isInsert = (memberBean.getMiNo() ==null); // 判斷是否為insert
        MemberBean memberBean1 = memberService.saveHeadshotInDB(memberBean,isInsert);//setImage( ) , setLocalfilename()
        memberService.save(memberBean1);  // 塞進DB後才產生miNo
        return "redirect:/FrontEnd/registerconfirm";  // 重導到email認證畫面 //redirect不帶資料
    }

    @GetMapping("/testregisterMember")
    public String registerConfirm() {
        return "FrontEnd/registerconfirm";
    }

    /*會員中心頁面*/
    @GetMapping("/my-account-home")
    public String myAccountHome() {
        return "FrontEnd/member/my-account"; }

}
