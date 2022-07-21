package com.revature.services;

import com.revature.dtos.UserDto;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByCredentials(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void resetPW(UserDto userDto) {
        System.out.println("USERDTO" + userDto);
        Optional<User> newUser = userRepository.findByEmailAndPassword(userDto.getEmail(), userDto.getCurrPW());
        if (newUser.isPresent()) {
            if (userDto.getNewPW().equals(userDto.getReNewPW())) {
                newUser.get().setPassword(userDto.getNewPW());
                userRepository.save(newUser.get());
            }
        }

    }
}
