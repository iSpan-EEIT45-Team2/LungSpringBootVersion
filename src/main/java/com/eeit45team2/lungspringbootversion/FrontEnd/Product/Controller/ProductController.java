//package com.eeit45team2.lungspringbootversion.FrontEnd.Product.Controller;
//
//import com.eeit45team2.lungspringbootversion.FrontEnd.Product.model.Product;
//import com.eeit45team2.lungspringbootversion.FrontEnd.Product.service.ProductService;
//import com.eeit45team2.lungspringbootversion.FrontEnd.common.ApiResponse;
//import com.eeit45team2.lungspringbootversion.backend.animal.util.FileUploadUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.sql.Timestamp;
//import java.util.Objects;
//
//@RestController
//@RequestMapping("/Front/Product")
//public class ProductController {
//
//    @Autowired
//    private ProductService productService;
//
//    @PostMapping("/add")
//    public ResponseEntity<ApiResponse> addProduct(@RequestBody Product product, @RequestParam(value = "productImage", required = false) MultipartFile multipartFile) throws IOException {
//        if (multipartFile != null) {
//            String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
//            product.setPd_image(fileName);
//            String uploadDir = "./src/main/resources/static/FrontEnd/images/product/";
//            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
//        }
//        Timestamp adminTime = new Timestamp(System.currentTimeMillis());
//        product.setAdmissionTime(adminTime);
//        productService.createProduct(product);
//
//        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "商品建立成功"), HttpStatus.CREATED);
//    }
//
//}
