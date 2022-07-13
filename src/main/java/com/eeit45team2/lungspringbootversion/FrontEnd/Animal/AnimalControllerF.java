package com.eeit45team2.lungspringbootversion.FrontEnd.Animal;

import com.eeit45team2.lungspringbootversion.backend.animal.model.AbDogBean;
import com.eeit45team2.lungspringbootversion.backend.animal.service.AbDogService;
import com.eeit45team2.lungspringbootversion.backend.animal.util.FileUploadUtil;
import com.eeit45team2.lungspringbootversion.backend.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;

@Controller
public class AnimalControllerF {
    @Autowired
    private AbDogService abDogService;



//    @GetMapping("animals")
//    public String showAnimal(Model model, @Param("keyword") String keyword) {//call service撈資料 >連API>listall
//        List <AbDogBean> animal = abDogService.abdoglistAll(keyword);
//        model.addAttribute("animals", animal);
//        model.addAttribute("keyword", keyword);
//
//        return "/BackendAnimal/BackAbDog";
//        //真實程式 非虛擬路徑
//    }
    @GetMapping("/animals")
    public String showAnimal(Model model, @Param("keyword") String keyword) {
        List<AbDogBean> animal = abDogService.abdoglistAll(keyword);
        model.addAttribute("animals", animal);
        model.addAttribute("keyword", keyword);

        return "FrontEnd/Animal/blog";
    }

    @RequestMapping("/animalForm")
    public String showFormForAdd(Model model) {
        AbDogBean abdogbean = new AbDogBean();
        model.addAttribute("animals", abdogbean);
        return "/FrontEnd/Animal/blog-details";
    }
//    @PostMapping("/saveAnimal")
//    public RedirectView AnimalSave(AbDogBean abdogbean,
//                                  @RequestParam("image") MultipartFile multipartFile) throws IOException {
//        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//        abdogbean.setAbphonto(fileName);
//        abDogService.save(abdogbean);
//        //String uploadDir = "./user-photos/" +book.getId();./是當前目錄/user-photos/book.getId()
//        //   String uploadDir = "./user-photos/"  ;// ./是當前目錄/user-photos
//        String uploadDir = "./src/main/resources/static/BackEnd/images/animal/"  ;
//        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
//        return new RedirectView("/animals", true);
//    }
//
    @GetMapping("/animalUpdateForm/{abid}")
    public ModelAndView Update(@PathVariable Long abid) {
        ModelAndView mav = new ModelAndView("FrontEnd/Animal/blog-details");
        AbDogBean abDogBean = abDogService.get(abid);
        mav.addObject("animals", abDogBean);
        return mav;

}}
