package org.codewithme.store;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("email")
@Primary
public class EmailNotificationService  implements  NotificaitonService{
    @Override
    public void Send(String message) {
        System.out.println(message);
        System.out.println("Email Sent");
    }
}
