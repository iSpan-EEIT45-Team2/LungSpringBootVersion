package com.eeit45team2.lungspringbootversion.backend;

import com.eeit45team2.lungspringbootversion.backend.member.model.MemberBean;
import com.eeit45team2.lungspringbootversion.backend.member.service.impl.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Autowired
    CommonService commonService;

    @GetMapping("/default")
    public String redirect(){
        MemberBean member = commonService.getCurrentMemerBean();
        if(member.getMiRole().equals("EMPLOYEE")){
            return "redirect:/index";
        }
        return "redirect:/Front";
    }
}
