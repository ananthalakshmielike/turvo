package com.turvo.assesment.shipmenttracking.notification.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.turvo.assesment.shipmenttracking.notification.Message;
import com.turvo.assesment.shipmenttracking.notification.NotificationSender;

/**
 * 
 * Implementation of NotificationSender for Email type. This class is responsible for
 * sending email to the customer.
 *
 * @author Sandeep Allamsetti
 *
 */
@Component
public class EmailNotificationSender implements NotificationSender {

	
	@Autowired
	JavaMailSender mailSender;
	
	@Override
	public int sendNotification(Message message) {
		mailSender.send(new SimpleMailMessage());
		return 0;
	}

}
