package org.seongjki.command;

import org.seongjki.user.User;

public class MessageArgs implements CommandArg {

    private String channelName;

    private String msg;

    private User requester;

    public String getChannelName() {
        return channelName;
    }

    public String getMsg() {
        return msg;
    }

    public User getRequester() {
        return requester;
    }
}
