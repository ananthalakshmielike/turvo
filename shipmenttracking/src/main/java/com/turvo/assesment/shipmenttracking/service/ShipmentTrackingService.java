package com.turvo.assesment.shipmenttracking.service;

import org.springframework.stereotype.Service;

import com.turvo.assesment.shipmenttracking.exception.ShipmentTrackingApplicationException;
import com.turvo.assesment.shipmenttracking.model.Shipment;

/**
 * Service class responsible for creating/tracking/updating the status of
 * shipments created for the customer delivery.
 * 
 * @author Sandeep Allamsetti
 *
 */
@Service
public interface ShipmentTrackingService {

	Shipment createShipment(Shipment shipment) throws ShipmentTrackingApplicationException;

	Shipment updateShipment(Shipment shipment) throws ShipmentTrackingApplicationException;

	Shipment trackShipment(String shipmentId) throws ShipmentTrackingApplicationException;
}
