package org.codewithme.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StoreApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);

//
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
