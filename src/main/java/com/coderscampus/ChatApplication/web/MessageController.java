package com.coderscampus.ChatApplication.web;

import com.coderscampus.ChatApplication.entity.Message;
import com.coderscampus.ChatApplication.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/messages/{channelId}")//<-use Spring MVC to map HTTP GET requests to a specific handler method.
    public List<Message> getMessagesByChannelId(@PathVariable Long channelId) {
        List<Message> messages = messageService.getMessagesFromChannelId(channelId);
        return  messages; // Back to the client caller
    }

    @PostMapping("/messages")
    public Message createNewMessage(@RequestBody Message message) {
        messageService.saveMessageToChannel(message);
        System.out.println(message);
        return message;
    }
}
