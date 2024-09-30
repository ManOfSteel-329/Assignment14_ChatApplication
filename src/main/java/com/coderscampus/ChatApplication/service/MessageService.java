package com.coderscampus.ChatApplication.service;

import com.coderscampus.ChatApplication.entity.Channel;
import com.coderscampus.ChatApplication.entity.Message;
import com.coderscampus.ChatApplication.repository.ChannelRepository;
import com.coderscampus.ChatApplication.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    ChannelRepository channelRepository;
    @Autowired
    MessageRepository messageRepository;


//  Fetch message associated with the given channelID
    public List<Message> getMessagesFromChannelId(Long channelId) {
        return messageRepository.getMessagesFromChannelId(channelId).orElse(new ArrayList<>());
        //returns back to the client who called it
    }

    public void saveMessageToChannel(Message message) {
        Long channelId = message.getChannelId();
        Channel channel = channelRepository.findById(channelId);

        if (!channel.getChannelName().isEmpty()) {
            // find the list of messages belonging to the channel with id channelId
//        Optional<List<Message>> messages = messageRepository.getMessagesFromChannelId(channelId);
            List<Message> messages = getMessagesFromChannelId(channelId);

            //It feels like message should be one of the fields of a channel

            // append the new message to it
            messages.add(message);

            // save this updated list of messages
            messageRepository.saveMessagesInChannel(channelId, messages);
        }
    }


}
