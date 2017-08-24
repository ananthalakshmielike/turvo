package com.turvo.assesment.shipmenttracking.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.jms.ConnectionFactory;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.turvo.assesment.shipmenttracking.notification.ShipmentStatusMessage;

/**
 * Configuration class responsible for initializing the required beans and
 * creating default factory classes.
 * 
 * @author Sandeep Allamsetti
 * 
 */
@Configuration
public class BaseConfiguration {
	

	@Bean
    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
                                                    DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        return factory;
    }

    @Bean 
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        
        Map<String, Class<?>> typeMappings = new HashMap<>();
        typeMappings.put("ShipmentStatusMessage", ShipmentStatusMessage.class);
        converter.setTypeIdMappings(typeMappings);
        converter.setTypeIdPropertyName("ShipmentStatusMessage");
        return converter;
    }
    
    @Bean
    public JmsTemplate  jmsTemplate(ConnectionFactory connectionFactory) {
    	return new JmsTemplate(connectionFactory);
    }
    
    @Bean
    public JavaMailSenderImpl mailSender() {
        Properties props = new Properties();
        props.put("mail.smtp.auth",true);
        props.put("mail.smtp.starttls.enable",true);
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.user", "helpdesk@turvo.com");
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.password", "Dev@stage1");
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setJavaMailProperties(props);
        mailSender.setPort(587);
        mailSender.setHost("smtp.office365.com");
        mailSender.setPassword("Dev@stage1");
        mailSender.setUsername("helpdesk@turvo.com");
        mailSender.setProtocol("smtp");

        return mailSender;
    }
    
    

}
