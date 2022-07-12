package com.eeit45team2.lungspringbootversion.FrontEnd.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Front")
public class ViewController {

    @GetMapping
    public String index(HttpSession session) {
        session.setAttribute("test", "1234");
        return "FrontEnd/FrontIndex";
    }


    @GetMapping("/my-account-home")
    public String myAccountHome() {
        return "FrontEnd/member/my-account";
    }
}


