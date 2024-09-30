package com.coderscampus.ChatApplication.web;

import com.coderscampus.ChatApplication.entity.User;
import com.coderscampus.ChatApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public User createUser (@RequestBody String name) {
        User user = userService.createUser(name);
        System.out.println(user.getName() + " " + user.getId());
        System.out.println(user.getChannels());
        System.out.println(user.getMessages());
        return user;
    }
}
