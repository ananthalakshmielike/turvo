package com.turvo.assesment.shipmenttracking.exception;

public class ShipmentTrackingApplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1635259480908292100L;

	public ShipmentTrackingApplicationException() {
		super();
	}

	public ShipmentTrackingApplicationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ShipmentTrackingApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ShipmentTrackingApplicationException(String message) {
		super(message);
	}

	public ShipmentTrackingApplicationException(Throwable cause) {
		super(cause);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
