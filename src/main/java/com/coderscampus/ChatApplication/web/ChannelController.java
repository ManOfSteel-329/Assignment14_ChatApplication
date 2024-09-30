package com.coderscampus.ChatApplication.web;

import com.coderscampus.ChatApplication.entity.Channel;
import com.coderscampus.ChatApplication.entity.Message;
import com.coderscampus.ChatApplication.service.ChannelService;
import com.coderscampus.ChatApplication.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ChannelController {

    @Autowired
    ChannelService channelService;

    @Autowired
    MessageService messageService;

    @GetMapping("/")
    public String showWelcomePage(){
        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String getChannels(ModelMap model){
        List<Channel> channels = channelService.findAll();
        model.put("channels", channels);
        return "welcome";
    }

    @PostMapping("/create-channel")
    public String createChannel(@RequestParam String channelName){
        System.out.println(channelName);
        channelService.save(channelName);
        return "redirect:/";
    }

    @GetMapping("/channels/{channelId}")
    public String getChannel(ModelMap model, @PathVariable Long channelId) {
        Channel channel = channelService.findById(channelId);
        List<Message> messagesFromChannelId = messageService.getMessagesFromChannelId(channelId);

        model.put("messages", messagesFromChannelId);
        model.put("channel", channel);
        return "channel";
    }

}
