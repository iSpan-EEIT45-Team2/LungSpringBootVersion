package com.eeit45team2.lungspringbootversion.Frontend.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/FrontEnd")
public class FrontViewController {

    @RequestMapping("/Product")
    public String productView() {
        return "/FrontEndProduct/Product";
    }
}
