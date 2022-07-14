package com.eeit45team2.lungspringbootversion.backend.member.controller;

import com.eeit45team2.lungspringbootversion.backend.member.service.impl.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/memberInfo")
public class MemberInfoController {

    @Autowired
    CommonService commonService;

    @GetMapping("/getCurrentUserMiName")
    public @ResponseBody String getCurrentUserMiName(){
        return commonService.getCurrentUserMiName(); // 呼叫CustomUserDetails.java取得那裡變數member的name
    }

    @GetMapping("/getCurrentUserImage")
    public ResponseEntity<byte[]> getCurrentUserImage(){
        return commonService.getCurrentUserImage();
    }
}
