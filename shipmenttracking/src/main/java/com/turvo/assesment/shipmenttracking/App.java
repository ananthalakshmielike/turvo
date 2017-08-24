package com.turvo.assesment.shipmenttracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;

/**
 * Main application class which initializes all the required configuration &
 * boot the application
 * 
 * @author Sandeep Allamsetti
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableJms
@EnableJpaRepositories
public class App {

	public static void main(String[] args) {

		System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES",
				"java.lang, javax.security, java.util, org.apache.activemq, org.fusesource.hawtbuf, com.thoughtworks.xstream.mapper,com.turvo.assesment.shipmenttracking,com.turvo.assesment.shipmenttracking.notification");
		SpringApplication.run(App.class, args);
	}
	
}
