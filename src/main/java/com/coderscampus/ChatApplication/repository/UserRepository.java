package com.coderscampus.ChatApplication.repository;

import com.coderscampus.ChatApplication.entity.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserRepository {

    private Set<User> users = new HashSet<>();

    public User save(User user) {
        user.setId((long) users.size() + 1);
        users.add(user);
        return user;
    }
}
