package org.codewithme.store;

import org.codewithme.store.entities.Address;
import org.codewithme.store.entities.User;
import org.codewithme.store.repositories.AddressRepository;
import org.codewithme.store.repositories.UserRepository;
import org.codewithme.store.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StoreApplication {
    public static void main(String[] args) {

        SpringApplication.run(StoreApplication.class, args);
//
//        ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);
//
//        var userService = context.getBean(UserService.class);
//        userService.deleteRelated();
    }
}
