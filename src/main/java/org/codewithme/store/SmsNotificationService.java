package org.codewithme.store;

import org.springframework.stereotype.Service;

@Service("sms")
public class SmsNotificationService implements NotificaitonService{
    @Override
    public void Send(String message) {
        System.out.println(message);
        System.out.println("SMS Sent");
    }
}
