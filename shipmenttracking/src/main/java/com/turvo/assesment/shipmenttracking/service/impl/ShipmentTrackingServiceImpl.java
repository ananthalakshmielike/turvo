package com.turvo.assesment.shipmenttracking.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.turvo.assesment.shipmenttracking.exception.ShipmentTrackingApplicationException;
import com.turvo.assesment.shipmenttracking.model.Shipment;
import com.turvo.assesment.shipmenttracking.notification.ShipmentStatusMessage;
import com.turvo.assesment.shipmenttracking.repository.ShipmentRepository;
import com.turvo.assesment.shipmenttracking.service.ShipmentTrackingService;

@Service
public class ShipmentTrackingServiceImpl implements ShipmentTrackingService {

	@Autowired
	ShipmentRepository shipmentRepository;

	@Autowired
	JmsTemplate jmsTemplate;

	private String[] ignoreProperties = { "created", "id", "customer", "shipmentId" };

	@Override
	public Shipment createShipment(Shipment shipment) throws ShipmentTrackingApplicationException {
		Shipment createdShipment = shipmentRepository.save(shipment);
		sendShipmentStatusChangedNotification(createdShipment);
		return createdShipment;
	}

	@Override
	public Shipment updateShipment(Shipment shipment) throws ShipmentTrackingApplicationException {
		Shipment oldShipment = shipmentRepository.findOne(shipment.getShipmentId());
		BeanUtils.copyProperties(shipment, oldShipment, ignoreProperties);
		Shipment updatedShipment = shipmentRepository.save(oldShipment);
		sendShipmentStatusChangedNotification(updatedShipment);
		return updatedShipment;
	}

	@Override
	public Shipment trackShipment(String shipmentId) throws ShipmentTrackingApplicationException {
		return shipmentRepository.findOne(shipmentId);
	}

	/**
	 * Method responsible for sending the notification message to
	 * shipmentTrackingQueue
	 * 
	 * @param status
	 *            the ShipmentStatus
	 */

	private void sendShipmentStatusChangedNotification(Shipment shipment) {
		jmsTemplate.convertAndSend("shipmentStatusQueue", new ShipmentStatusMessage(shipment.getShipmentId(),
				shipment.getStatus(), shipment.getCustomer().getId()));
	}

}
