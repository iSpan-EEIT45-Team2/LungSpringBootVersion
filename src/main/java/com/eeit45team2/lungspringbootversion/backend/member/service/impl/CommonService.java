package com.eeit45team2.lungspringbootversion.backend.member.service.impl;

import com.eeit45team2.lungspringbootversion.backend.member.model.CustomUserDetails;
import com.eeit45team2.lungspringbootversion.backend.member.model.MemberBean;
import com.eeit45team2.lungspringbootversion.backend.member.service.MemberService;
import com.eeit45team2.lungspringbootversion.backend.member.util.CommonFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
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

    public @ResponseBody String getCurrentUserMiName(){
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return customUserDetails.getMiname(); // 呼叫CustomUserDetails.java取得那裡變數member的name
    }


    public ResponseEntity<byte[]> getCurrentUserImage() {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long currentUserMiNo = customUserDetails.getMino();

        byte[] body = null;
        ResponseEntity<byte[]> responseEntity = null;
        MediaType mediaType = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setCacheControl(CacheControl.noCache().getHeaderValue());
        MemberBean member = memberService.findById(currentUserMiNo);

        // 沒有會員資料
        if(member == null) {
            return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
        }else {
            // 有會員資料
            String localfilename = member.getLocalfileName();
//			Blob image = member.getImage();
            // 有local檔名 -> 因為csv直接匯入 || 有新增照片
            if(localfilename != null) {
                // 設定ResponseHeaders
                /* 透過檔名 setContentType(MediaType) */
                if (localfilename.toLowerCase().endsWith("jfif")) {
                    mediaType = MediaType.valueOf(ctx.getMimeType("dummy.jpeg"));
                } else {
                    mediaType = MediaType.valueOf(ctx.getMimeType(localfilename));
                    headers.setContentType(mediaType);
                }
                // 設定ResponseBody
//				body = getServerFileToByteArray("/resources/images/memberHeadshot" + localfilename);  //有問題: 每次都產生暫時目錄
                body = commonFunction.blobToByteArray(member.getImage()); // 改成抓DB圖片
            }else {
                //沒有local檔名 -> 新增不傳圖片 -> 所以要顯示預設圖片
                body = commonFunction.getProjectFileToByteArray(".\\src\\main\\resources\\static\\BackEnd\\images\\memberHeadshot\\defaultHeadshot.jpg");  //如果圖片為空，就上傳預設圖片
            }
            responseEntity = new ResponseEntity<byte[]>(body, headers, HttpStatus.OK);
            return responseEntity;
        }
    }




}
