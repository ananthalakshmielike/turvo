package com.turvo.assesment.shipmenttracking.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turvo.assesment.shipmenttracking.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Serializable> {

}
