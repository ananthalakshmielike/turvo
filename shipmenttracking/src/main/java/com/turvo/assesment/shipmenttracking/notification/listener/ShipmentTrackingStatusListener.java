package com.turvo.assesment.shipmenttracking.notification.listener;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.turvo.assesment.shipmenttracking.enums.PreferenceType;
import com.turvo.assesment.shipmenttracking.exception.ShipmentTrackingApplicationException;
import com.turvo.assesment.shipmenttracking.model.Customer;
import com.turvo.assesment.shipmenttracking.notification.NotificationSender;
import com.turvo.assesment.shipmenttracking.notification.ShipmentStatusMessage;
import com.turvo.assesment.shipmenttracking.service.CustomerService;

@Component
public class ShipmentTrackingStatusListener {
	
	@Autowired 
	CustomerService customerService;
	
	NotificationSender notificationSender;

	@JmsListener(destination = "shipmentStatusQueue", containerFactory = "myFactory")
    public void receiveMessage(ShipmentStatusMessage shipment) {
		try {
			Customer customer = customerService.getCustomer(shipment.getCustomerId());
			Collection<PreferenceType> chanelPreferences = customer.getChanelPreferenceList();
			/*if(PreferenceType.Web == chanelPreference) {
				notificationSender = new WebNotificationSender();
			}*/
			
		} catch (ShipmentTrackingApplicationException e) {
			e.printStackTrace();
		}
    }
}
