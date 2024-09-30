package com.coderscampus.ChatApplication.repository;

import com.coderscampus.ChatApplication.entity.Message;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MessageRepository {

    public Map<Long, List<Message>> messages = new HashMap<>();


    public Optional<List<Message>> getMessagesFromChannelId(Long channelId) {
        List<Message> messageList = messages.get(channelId);
        return Optional.ofNullable(messageList);
    }

    public void saveMessagesInChannel(Long channelId, List<Message> messages) {
        this.messages.put(channelId, messages);
    }
}
