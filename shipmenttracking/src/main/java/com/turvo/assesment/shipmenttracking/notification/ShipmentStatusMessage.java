package com.turvo.assesment.shipmenttracking.notification;

import java.io.Serializable;

import com.turvo.assesment.shipmenttracking.enums.ShipmentStatus;

public class ShipmentStatusMessage implements Serializable {

	public ShipmentStatusMessage(int shipmentId, ShipmentStatus shipmentStatus, int customerId) {
		this.shipmentId = shipmentId;
		this.shipmentStatus = shipmentStatus;
		this.customerId = customerId;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6350030736861174714L;

	private int shipmentId;
	
	private int customerId;

	private ShipmentStatus shipmentStatus;

	public int getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}

	public ShipmentStatus getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(ShipmentStatus shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
