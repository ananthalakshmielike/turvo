package com.turvo.assesment.shipmenttracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.turvo.assesment.shipmenttracking.exception.ShipmentTrackingApplicationException;
import com.turvo.assesment.shipmenttracking.model.Customer;
import com.turvo.assesment.shipmenttracking.service.CustomerService;

/**
 * Controller class exposing the api's to create, update, get
 * Customer details.
 *  
 * @author Sandeep Allamsetti
 */

@RestController
@RequestMapping("/customer")
public class CustomerResourceController {

	@Autowired
	CustomerService customerService;

	/**
	 * Method to create customer entity
	 * 
	 * @param customer the customer input object
	 * @return customer the created response object of customer type
	 */
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

	/**
	 * Method to update customer entity like updating the 
	 * preference channel , subscription events etc
	 * 
	 * @param customer the customer object with updated properties
	 * @return customer the updated response object of customer type
	 */
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
	
	/**
	 * Method to return the customer details 
	 * 
	 * @param customer the customer object with updated properties
	 * @return customer the updated response object of customer type
	 */
	@RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
	public ResponseEntity<?> getCustomer(@PathVariable("customerId") int customerId) {
		Customer response;
		try {
			response = customerService.getCustomer(customerId);
			return new ResponseEntity<Customer>(response, HttpStatus.OK);
		} catch (ShipmentTrackingApplicationException e) {
			return new ResponseEntity<String>("Error updating customer", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
