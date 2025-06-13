package org.codewithme.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StoreApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var userService = context.getBean(UserService.class);
        userService.registerUser(new User(1L, "me@gmail.com", "12345", "Mohamed"));
        userService.registerUser(new User(1L, "me@gmail.com", "12345", "Mohamed"));


//          var orderService = context.getBean(OrderServive.class);
//          orderService.placeOrder();
//          var notificationManager = context.getBean(NotificationManager.class);
//          notificationManager.Send("Order created");
//          context.close();
    }
}
