package com.turvo.assesment.shipmenttracking.service;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.turvo.assesment.shipmenttracking.model.Shipment;

@Component
public class Receiver {

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    public void receiveMessage(Shipment shipment) {
        System.out.println("Received <" + shipment + ">");
    }

}