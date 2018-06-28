/**
 * @author Tae Kyoo Yang
 *
 */
package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.*;

import static org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType.HAL;

@EnableEntityLinks
@EnableHypermediaSupport(type = HAL)
@SpringBootApplication
public class Application {
	
	/*
	 * Main method of the Application class.  Called to start the Spring Framework
	 */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}