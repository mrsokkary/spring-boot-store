package org.codewithme.store.services;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.codewithme.store.entities.Address;
import org.codewithme.store.entities.Profile;
import org.codewithme.store.entities.User;
import org.codewithme.store.repositories.AddressRepository;
import org.codewithme.store.repositories.ProfileRepository;
import org.codewithme.store.repositories.UserRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor

@Service
public class UserService {

    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;

    @Transactional
    public void showEntityStates()
    {
        var user = User.builder()
                .name("moahmed")
                .password("test")
                .email("moahmed@gmail.com")
                .build();

        if(entityManager.contains(user))
            System.out.println("user found in presistant");
        else System.out.println("user not found in presistant Tranisient / Detached");

        userRepository.save(user);

        if(entityManager.contains(user))
            System.out.println("user found in presistant");
        else System.out.println("user not found in presistant Tranisient / Detached");
    }

    @Transactional
    public void getUserProfile()
    {
        var profile = profileRepository.findById(2L).orElseThrow();
        System.out.println(profile.toString());
        System.out.println(profile.getUser().getName());
    }

    @Transactional
    public void getUserAdderss()
    {
        var address =  addressRepository.findById(1L).orElseThrow();
        System.out.println(address.getCity());

    }

    public void presisitRelated()
    {
        var user = User.builder()
                .name("moahmed")
                .password("test")
                .email("moahmed@gmail.com")
                .build();

        var address = Address.builder().street("street").city("city").zip("zip").state("state")
                .build();

        user.addAddress(address);

        userRepository.save(user);
    }

    public void deleteRelated()
    {
        userRepository.deleteById(2L);
    }
}
