package com.turvo.assesment.shipmenttracking.notification.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.turvo.assesment.shipmenttracking.model.Alert;
import com.turvo.assesment.shipmenttracking.notification.Message;
import com.turvo.assesment.shipmenttracking.notification.NotificationSender;
import com.turvo.assesment.shipmenttracking.repository.AlertRepository;

/**
 * 
 * Implementation of NotificationSender for Web channel type. This class is responsible for
 * creating alert messages for the customer based on the events subscribed for.
 * These alters will be displayed for the customer once login to the web portal.
 *
 * @author Sandeep Allamsetti
 *
 */
@Component
public class WebNotificationSender implements NotificationSender {
	
	@Autowired
	AlertRepository alertRepository;

	@Override
	public int sendNotification(Message message) {
		Alert webNotification = new Alert();
		webNotification.setMessage(message.getMessageText());
		alertRepository.save(webNotification);
		return 0;
	}

}
