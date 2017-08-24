package com.turvo.assesment.shipmenttracking.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turvo.assesment.shipmenttracking.exception.ShipmentTrackingApplicationException;
import com.turvo.assesment.shipmenttracking.model.Customer;
import com.turvo.assesment.shipmenttracking.repository.CustomerRepository;
import com.turvo.assesment.shipmenttracking.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private String[] ignoreProperties = { "name", "id", "email", "contactNumber","subscribeList" };
	
	@Autowired
	CustomerRepository customerRepository;


	@Override
	public Customer createCustomer(Customer customer) throws ShipmentTrackingApplicationException {
		Customer cust = customerRepository.save(customer);
		return cust;

	}

	@Override
	public Customer updateCustomerPreferences(Customer customer) throws ShipmentTrackingApplicationException {
		Customer cust = customerRepository.findOne(customer.getId());
		BeanUtils.copyProperties(customer, cust, ignoreProperties);
		customerRepository.save(cust);
		return cust;

	}

	@Override
	public Customer getCustomer(int customerId) throws ShipmentTrackingApplicationException {
		return customerRepository.findOne(customerId);
	}

}
