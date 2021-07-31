package org.devtest.contactbackend.service;

import org.devtest.contactbackend.dao.UserRepository;
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
}
