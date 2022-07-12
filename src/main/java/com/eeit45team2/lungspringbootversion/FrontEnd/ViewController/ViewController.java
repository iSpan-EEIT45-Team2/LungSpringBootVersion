package com.eeit45team2.lungspringbootversion.FrontEnd.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Front")
public class ViewController {

    @GetMapping
    public String index() {
        return "FrontEnd/FrontIndex";
    }

    @GetMapping("/products")
    public String shop() {
        return "FrontEnd/Shop/shop";
    }

    @GetMapping("/my-account-home")
    public String myAccountHome() {
        return "FrontEnd/member/my-account";
    }

    @GetMapping("/animals")
    public String animal() {
        return "FrontEnd/Animal/animal";
    }
}


