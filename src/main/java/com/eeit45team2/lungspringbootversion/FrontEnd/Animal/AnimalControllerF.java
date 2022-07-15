package com.eeit45team2.lungspringbootversion.FrontEnd.Animal;

import com.eeit45team2.lungspringbootversion.backend.animal.model.AbDogBean;
import com.eeit45team2.lungspringbootversion.backend.animal.repository.AbDogRepository;
import com.eeit45team2.lungspringbootversion.backend.animal.service.AbDogService;
import com.eeit45team2.lungspringbootversion.backend.animal.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
@RequestMapping("FrontEndAnimalF")
public class AnimalControllerF {
    @Autowired
    private AbDogService abDogService;
    @Autowired
    private AbDogRepository abdogRepository;
    @Autowired
    private JavaMailSender mailSender;
    @GetMapping("/animals")
    public String showAnimal(Model model, @Param("keyword") String keyword) {
        List<AbDogBean> animal = abDogService.abdoglistAll(keyword);
        model.addAttribute("animals", animal);
        model.addAttribute("keyword", keyword);

        return "FrontEnd/Animal/anblog";
    }

    @RequestMapping("/animalForm")
    public String showFormForAdd(Model model) {
        AbDogBean abdogbean = new AbDogBean();
        model.addAttribute("animals", abdogbean);
        return "/FrontEnd/Animal/anblog-save";
    }
    @PostMapping("/saveAnimal")
    public RedirectView AbDogSave(AbDogBean abdogbean,
                                  @RequestParam("image") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        SimpleMailMessage message = new SimpleMailMessage();

        abdogbean.setAbphonto(fileName);
        abDogService.save(abdogbean);
        //String uploadDir = "./user-photos/" +book.getId();./是當前目錄/user-photos/book.getId()
        //   String uploadDir = "./user-photos/"  ;// ./是當前目錄/user-photos
        String uploadDir = "./src/main/resources/static/BackEnd/images/animal/";
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        message.setFrom("Lunghipeace0302@gmail.com");
        message.setTo(abdogbean.getAbemail());
        message.setSubject("謝謝您的來信");
        message.setText("目前表單正在審核中");
        mailSender.send(message);
        System.out.println("Mail Sent succesfully...");

        return new RedirectView("/animals", true);
    }


    @GetMapping("/animalUpdateForm/{abid}")
    public ModelAndView Update(@PathVariable Long abid) {
        ModelAndView mav = new ModelAndView("FrontEnd/Animal/anblog-details");
        AbDogBean abDogBean = abDogService.get(abid);
        mav.addObject("animals", abDogBean);
        return mav;

}



}
