package org.codewithme.store;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotificationManager {
    private final NotificaitonService notificaitonService;

    public NotificationManager(@Qualifier("sms") NotificaitonService notificaitonService) {
        this.notificaitonService = notificaitonService;
    }

    public void Send(String message) {
        notificaitonService.Send(message);
    }
}
