package com.turvo.assesment.shipmenttracking.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turvo.assesment.shipmenttracking.model.Alert;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Serializable> {

}
