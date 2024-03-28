package com.ipl_spring_xml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class IplSpringXmlApplication {

	public static void main(String[] args) {
		// Load the Spring context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the bean from the Spring context
        iplService ipService = (iplService) context.getBean("iplService");

        ipService.runMenu();
	}

}
