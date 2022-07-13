package com.eeit45team2.lungspringbootversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class LungSpringBootVersionApplication {


	public static void main(String[] args) {
		SpringApplication.run(LungSpringBootVersionApplication.class, args);
	}
//
}


