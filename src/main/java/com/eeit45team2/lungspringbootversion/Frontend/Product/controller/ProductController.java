package com.eeit45team2.lungspringbootversion.Frontend.Product.controller;

import com.eeit45team2.lungspringbootversion.Frontend.Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    

}
