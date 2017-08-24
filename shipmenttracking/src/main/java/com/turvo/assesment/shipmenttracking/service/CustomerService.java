package com.turvo.assesment.shipmenttracking.service;

import org.springframework.stereotype.Service;

import com.turvo.assesment.shipmenttracking.exception.ShipmentTrackingApplicationException;
import com.turvo.assesment.shipmenttracking.model.Customer;

@Service
public interface CustomerService {

	Customer createCustomer(Customer customer) throws ShipmentTrackingApplicationException;

	Customer updateCustomerPreferences(Customer customer) throws ShipmentTrackingApplicationException;

	Customer getCustomer(int customerId) throws ShipmentTrackingApplicationException;
}
