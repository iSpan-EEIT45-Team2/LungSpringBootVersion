package com.eeit45team2.lungspringbootversion.FrontEnd.Product;

import com.eeit45team2.lungspringbootversion.backend.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
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
    public String showProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "FrontEnd/Shop/shop";
    }

}
