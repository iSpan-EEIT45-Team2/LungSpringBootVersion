package com.eeit45team2.lungspringbootversion.backend.member.service.impl;

import com.eeit45team2.lungspringbootversion.backend.member.model.CustomUserDetails;
import com.eeit45team2.lungspringbootversion.backend.member.model.MemberBean;
import com.eeit45team2.lungspringbootversion.backend.member.service.MemberService;
import com.eeit45team2.lungspringbootversion.backend.member.util.CommonFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;

@Service
public class CommonService {

    @Autowired
    private MemberService memberService;

    @Autowired
    private CommonFunction commonFunction;

    @Autowired
    ServletContext ctx;


    public String getCurrentUserMiGender() {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("當前登入的會員性別是: " + customUserDetails.getMigender());
        return customUserDetails.getMigender();

    }

    public MemberBean getCurrentMemerBean() {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("當前登入的會員是: " + customUserDetails.getUser());
        return customUserDetails.getUser();

    }

    public Long getCurrentUserMiNo() {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("當前登入的會員編號是: " + customUserDetails.getMino());
        return customUserDetails.getMino();

    }

    public String getCurrentUserMiNameString() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) { // user不是anonymousUser
            CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            System.out.println("當前登入的會員姓名是: " + customUserDetails.getMiname());
            return customUserDetails.getMiname();
        } else {
            return (String) authentication.getPrincipal(); //是anonymousUser
        }
    }

        /*疑似有bug*/
//    public @ResponseBody String getCurrentUserMiName() {
//        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        return customUserDetails.getMiname(); // 呼叫CustomUserDetails.java取得那裡變數member的name
//    }


    public ResponseEntity<byte[]> getCurrentUserImage() {
        byte[] body = null;
        ResponseEntity<byte[]> responseEntity = null;
        MediaType mediaType = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setCacheControl(CacheControl.noCache().getHeaderValue());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MemberBean member = null;

        // user不是anonymousUser ->　已登入
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            member = customUserDetails.getUser();
            String localfilename = member.getLocalfileName();
            // 有local檔名 -> 因為csv直接匯入 || 有新增照片
            if (localfilename != null) {
                // 設定ResponseHeaders
                if (localfilename.toLowerCase().endsWith("jfif")) {
                    mediaType = MediaType.valueOf(ctx.getMimeType("dummy.jpeg"));
                } else {
                    mediaType = MediaType.valueOf(ctx.getMimeType(localfilename));
                    headers.setContentType(mediaType);
                }
                // 設定ResponseBody
                body = commonFunction.blobToByteArray(member.getImage()); // 改成抓DB圖片
            } else {
                //沒有local檔名 -> 新增不傳圖片
//                member.getMiAccount().equals(defaultAccount);
                switch (member.getMiAccount()) {
                    case "admin":
                        body = commonFunction.getProjectFileToByteArray("./src/main/resources/static/BackEnd/images/memberHeadshot/luffy.jpg");
                        break;
                    case "employee":
                        body = commonFunction.getProjectFileToByteArray("./src/main/resources/static/BackEnd/images/memberHeadshot/nami.jpg");
                        break;
                    case "active":
                        body = commonFunction.getProjectFileToByteArray("./src/main/resources/static/BackEnd/images/memberHeadshot/choppa.jpg");
                        break;
                    case "user":
                        body = commonFunction.getProjectFileToByteArray("./src/main/resources/static/BackEnd/images/memberHeadshot/sanji.jpg");
                        break;
                    default:
                        // 顯示預設圖片
                        body = commonFunction.getProjectFileToByteArray("./src/main/resources/static/BackEnd/images/memberHeadshot/defaultHeadshot.jpg");
                }
            }
        } else {
            // user未登入 -> show default
            body = commonFunction.getProjectFileToByteArray("./src/main/resources/static/BackEnd/images/memberHeadshot/defaultUserIcon.jpg");
//            return (String) authentication.getPrincipal(); //是anonymousUser
        }
        responseEntity = new ResponseEntity<byte[]>(body, headers, HttpStatus.OK);
        return responseEntity;
    }
}





