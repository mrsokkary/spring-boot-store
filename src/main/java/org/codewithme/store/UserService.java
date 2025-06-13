package org.codewithme.store;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final NotificaitonService notificaitonService;

    public UserService(UserRepository userRepository, NotificaitonService notificaitonService) {
        this.userRepository = userRepository;
        this.notificaitonService = notificaitonService;
    }

    public void registerUser(User user) {

        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("User with email " + user.getEmail() + " already exists");
        }

        userRepository.save(user);
        notificaitonService.send("You registered successfully!", user.getEmail());
    }
}
