package com.coderscampus.ChatApplication.repository;

import com.coderscampus.ChatApplication.entity.Channel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ChannelRepository {

    private List<Channel> channels = new ArrayList<>();

    public ChannelRepository() {
        Channel general = new Channel();
        general.setChannelId((long) 1);
        general.setChannelName("General");

        channels.add(general);
    }

    public Channel findById(Long id) {
        Optional<Channel> channel = channels
                .stream()
                // filter: Returns a stream consisting of the elements of
                // this stream that match the given predicate.
                // the predicate is the lambda function
                // c -> c.getId().equals(id)
                // predicate is a function that returns a boolean
                .filter(c -> c.getChannelId().equals(id))
                // Returns an Optional describing some element of the stream,
                // or an empty Optional if the stream is empty.
                .findAny();

        return channel.orElse(new Channel());
    }

    public List<Channel> findAll() {
        return channels;
    }
    // n n!
    // factorial(3)
    // return 3 * factorial(2)
    // return 3 * (2 * factorial(1))
    // return 3 * (2 * 1)
    // return 6
//    public int factorial(int n) {
//        if (n == 1) {
//            return 1;
//        } else {
//            return n * factorial(n - 1);
//        }
//    }

    public Channel save(String channelName){
        // create a new channel based on the channelName
        Channel channel = new Channel();
        // update the channel name, id
        channel.setChannelName(channelName);
        channel.setChannelId((long) channels.size() + 1);
        // int i = 4;
        // int k = i++; // fetch the original value in i first
        // k == 4
        // i == 5

        // int i = 4;
        // int k = ++i; // increment i first
        // k == 5
        // i == 5

        // Loads the value in a into memory (CPU)
        // assign i to k  (i++)
        // Add 1 to i
        // Store the result into variable

        // Loads the value in a into memory (CPU)
        // Add 1 to i
        // assign i to k  (i++)
        // Store the result into variable


        // rule of increment/decrement
        // 4++ ++4
        //
//        Long newId=channel.getId();
//        String newChannel =channel.getName();

        // add the new channel object into the database (in this case, the list)
        channels.add(channel);
        return channel;
    }
}
