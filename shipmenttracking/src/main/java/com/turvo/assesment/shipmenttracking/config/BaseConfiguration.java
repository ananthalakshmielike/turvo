package com.turvo.assesment.shipmenttracking.config;

import java.util.HashMap;
import java.util.Map;

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
        // This provides all boot's default to this factory, including the message converter
        configurer.configure(factory, connectionFactory);
        // You could still override some of Boot's default if necessary.
        return factory;
    }

    @Bean // Serialize message content to json using TextMessage
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
    
    

}
