package com.eeit45team2.lungspringbootversion.backend.springmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class WebMvcConfig implements WebMvcConfigurer {
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry
//                .addResourceHandler("/URLToReachResourcesFolder/**")
//                .addResourceLocations("/BackEnd/");
//        registry.addResourceHandler("/localImage/**").addResourceLocations("/resources/images/memberHeadshot/");
//        // 專案/headshot
//        // 專案/ member /list
//    }

//    @Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addRedirectViewController("/", "loginmain");
////		registry.addRedirectViewController("/logout", "logoutmain");
//	}
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
<<<<<<< HEAD
    registry.addResourceHandler("/image/**","/image3/**").addResourceLocations("file:src/main/resources/static/BackEnd/images/animal/"
            ,"file:src/main/resources/static/BackEnd/images/activity/");
    }
}
=======
    //registry.addResourceHandler("/image/**").addResourceLocations("file:user-photos/");
    registry.addResourceHandler("/image/**").addResourceLocations("file:src/main/resources/static/BackEnd/images/animal/");
    //path name                            //real path date.jpg
}
}
>>>>>>> fefb37cc038d1a582a32438edaf98c614c77ae42
