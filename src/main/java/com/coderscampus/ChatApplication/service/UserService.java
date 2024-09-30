package com.coderscampus.ChatApplication.service;

import com.coderscampus.ChatApplication.entity.User;
import com.coderscampus.ChatApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    public User createUser(String name) {
        User user = new User();
        user.setName(name);
        // return whatever gets returned as the result of calling userRepo.save(user)
        //return userRepo.save(user);
        userRepo.save(user);
        return user;
    }

    //-------------------------------------------------------------

    //-------------------------------------------------------------
}
