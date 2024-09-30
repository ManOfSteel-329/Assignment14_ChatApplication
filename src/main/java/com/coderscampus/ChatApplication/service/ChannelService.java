package com.coderscampus.ChatApplication.service;

import com.coderscampus.ChatApplication.entity.Channel;
import com.coderscampus.ChatApplication.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ChannelService {

    @Autowired
    public ChannelRepository  channelRepo;

    public Channel save(String channelName){
            return channelRepo.save(channelName);
    }


    public List<Channel> findAll() {
        return channelRepo.findAll();
//        Set<Channel> distinctChannels = new HashSet<>(channels);
//       return (List<Channel>) distinctChannels;
    }

    public Channel findById(Long channelId) {
        Channel channel = channelRepo.findById(channelId);
        return channel;
    }
}
