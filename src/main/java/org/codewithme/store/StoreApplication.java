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
        ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);

        var userService = context.getBean(UserService.class);
        userService.deleteRelated();

        //userService.showEntityStates();
//        var user1 = User.builder()
//                .name("moahmed")
//                .password("test")
//                .email("moahmed@gmail.com")
//                .build();
//
//        var userRepo = context.getBean(UserRepository.class);
//        //userRepo.save(user1);
//        userRepo.findAll().forEach(user ->  System.out.println(user.getEmail()));
//        userRepo.deleteById(1L);
//        var user = User.builder()
//                .name("moahmed")
//                .password("moahmed")
//                .email("ada@gmail.com")
//                .build();
//
//        var address = Address.builder().street("street").city("city").zip("zip").state("state")
//                .build();
//
//        user.addAddress(address);
//        System.out.println(user);
//
//       user.AddTag("tag1");
//
//        var profile = Profile.builder().bio("bio").build();
//        user.setProfile(profile);
//        profile.setUser(user);
//        System.out.println(user);

    }
}
