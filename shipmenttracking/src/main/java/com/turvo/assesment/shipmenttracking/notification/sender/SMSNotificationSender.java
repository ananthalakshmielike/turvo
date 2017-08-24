package com.turvo.assesment.shipmenttracking.notification.sender;

import org.springframework.stereotype.Component;

import com.turvo.assesment.shipmenttracking.notification.Message;
import com.turvo.assesment.shipmenttracking.notification.NotificationSender;

@Component
public class SMSNotificationSender implements NotificationSender {

	@Override
	public int sendNotification(Message message) {
		// TODO Auto-generated method stub
		return 0;
	}

}
