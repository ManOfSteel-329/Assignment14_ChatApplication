package com.coderscampus.ChatApplication.entity;

public class Channel {
    private Long channelId;
    private String channelName;


    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long id) {
        this.channelId = id;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "channelId=" + channelId +
                ", channelName='" + channelName + '\'' +
                '}';
    }
}
