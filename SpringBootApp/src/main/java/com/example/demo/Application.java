package com.example.demo;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
	
	private static Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) throws IOException {
		
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Application.class, args);
		assert (configurableApplicationContext!=null);
		
		logger.debug("The beans you were looking for are: ");
		
		String[] beans = configurableApplicationContext.getBeanDefinitionNames();
		/*
		for(String bean: beans) {
			System.out.println(bean);
		}
		*/
		
		HelloWorld hw = configurableApplicationContext.getBean(HelloWorld.class);
		hw.sayHi();
		
		System.in.read();
		
		configurableApplicationContext.close();
		
		System.exit(0);
		
	}

}
