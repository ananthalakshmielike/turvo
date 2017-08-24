package com.turvo.assesment.shipmenttracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.turvo.assesment.shipmenttracking.exception.ShipmentTrackingApplicationException;
import com.turvo.assesment.shipmenttracking.model.Customer;
import com.turvo.assesment.shipmenttracking.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerResourceController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
		Customer response;
		try {
			response = customerService.createCustomer(customer);
			return new ResponseEntity<Customer>(response, HttpStatus.CREATED);
		} catch (ShipmentTrackingApplicationException e) {
			return new ResponseEntity<String>("Error creating customer", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
		Customer response;
		try {
			response = customerService.createCustomer(customer);
			return new ResponseEntity<Customer>(response, HttpStatus.OK);
		} catch (ShipmentTrackingApplicationException e) {
			return new ResponseEntity<String>("Error updating customer", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
