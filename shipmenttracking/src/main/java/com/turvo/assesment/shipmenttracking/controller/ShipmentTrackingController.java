package com.turvo.assesment.shipmenttracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turvo.assesment.shipmenttracking.exception.ShipmentTrackingApplicationException;
import com.turvo.assesment.shipmenttracking.model.Shipment;
import com.turvo.assesment.shipmenttracking.repository.ShipmentRepository;
import com.turvo.assesment.shipmenttracking.service.ShipmentTrackingService;

@RestController
@RequestMapping("shipment")
public class ShipmentTrackingController {

	@Autowired
	ShipmentTrackingService shipmentTrackingService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createShipment(@RequestBody Shipment shipment) {
		try {
			Shipment response = shipmentTrackingService.createShipment(shipment);
			return new ResponseEntity<Shipment>(response, HttpStatus.CREATED);
		} catch (ShipmentTrackingApplicationException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error creating shipment", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<?> updateShipment(@RequestBody Shipment shipment) {
		try {
			Shipment response = shipmentTrackingService.updateShipment(shipment);
			return new ResponseEntity<Shipment>(response, HttpStatus.CREATED);
		} catch (ShipmentTrackingApplicationException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error updating shipment", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping("/track")
	public ResponseEntity<?> trackShipment(@RequestParam("shipmentId") String shipmentId) {

		try {
			Shipment response = shipmentTrackingService.trackShipment(shipmentId);
			return new ResponseEntity<Shipment>(response, HttpStatus.OK);
		} catch (ShipmentTrackingApplicationException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error creating shipment", HttpStatus.INTERNAL_SERVER_ERROR);
		}


	}
}
