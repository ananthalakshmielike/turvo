package com.turvo.assesment.shipmenttracking.notification;

/**
 * 
 * This sender must be implemented for sending status messages to the customer
 * over the preferred channel. like Web, Email and SMS etc.
 *
 * @author Sandeep Allamsetti
 *
 */
public interface NotificationSender {
     int sendNotification(Message message);
}
