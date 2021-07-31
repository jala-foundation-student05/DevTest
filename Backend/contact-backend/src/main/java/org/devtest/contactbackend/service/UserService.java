package org.devtest.contactbackend.service;

import org.devtest.contactbackend.dao.UserRepository;
import org.devtest.contactbackend.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ArrayList getUsers(){
        return new ArrayList (userRepository.findAll());
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User findUserbyId(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Error: That user don't exist."));
    }
}
