package com.turvo.assesment.shipmenttracking.notification.factory;

import com.turvo.assesment.shipmenttracking.enums.PreferenceType;
import com.turvo.assesment.shipmenttracking.notification.NotificationSender;
import com.turvo.assesment.shipmenttracking.notification.sender.EmailNotificationSender;
import com.turvo.assesment.shipmenttracking.notification.sender.SMSNotificationSender;
import com.turvo.assesment.shipmenttracking.notification.sender.WebNotificationSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationFactory {


    @Autowired
    private SMSNotificationSender smsNotificationSender;
    @Autowired
    private WebNotificationSender webNotificationSender;
    @Autowired
    private EmailNotificationSender emailNotificationSender;

    public NotificationSender getNotificationSender(PreferenceType preferenceType) {

        switch (preferenceType) {
            case Sms:
                return smsNotificationSender;
            case Web:
                return webNotificationSender;
            case Email:
                return emailNotificationSender;
            default:
                return webNotificationSender;
        }
    }

}
