package com.coderscampus.ChatApplication.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Long id;
    private String name;
    // different users have their own different list of messages and channels
    // Since these two lists are specific to the user who owns them,
    // we keep track of them as properties for each user
    // eg. user 1 has messages "hello", "hi", and "good morning"
    // but user 2 has messages "good night", "hi"
    // high cohesion, low coupling
    private List<Message> messages = new ArrayList<>();
    private List<Channel> channels = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", messages=" + messages +
                ", channels=" + channels +
                '}';
    }

}
