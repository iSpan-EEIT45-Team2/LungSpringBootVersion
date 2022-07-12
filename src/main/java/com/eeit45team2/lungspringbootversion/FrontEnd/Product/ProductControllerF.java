package com.eeit45team2.lungspringbootversion.FrontEnd.Product;

import com.eeit45team2.lungspringbootversion.backend.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/Front")
public class ProductControllerF {
    @Autowired
    private ProductService productService;


    //顯示商品
//    @GetMapping("/products")
//    public ModelAndView getAllProducts() {
//        ModelAndView modelAndView = new ModelAndView("/FrontEnd/Shop/shop"); //對應的html檔路徑
//        modelAndView.addObject("products", productService.findAll());
//        return modelAndView;
//    }
    @GetMapping("/products")
    public String showProducts(Model model, Principal principal) {
        model.addAttribute("products", productService.findAll());
        if (principal != null) {
            principal.getName();
            System.out.println("--------------------------");
            System.out.println("目前登入是: " + principal.getName());
            return "FrontEnd/Shop/shop";
        } else {
            return "login";
        }
    }

}
