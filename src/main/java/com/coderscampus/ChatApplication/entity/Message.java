package com.coderscampus.ChatApplication.entity;

public class Message {
    private Long channelId;
    private User user;
    private String contents;

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "Message{" +
                "channelId=" + channelId +
                ", user=" + user +
                ", contents='" + contents + '\'' +
                '}';
    }
}
