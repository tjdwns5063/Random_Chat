package org.seongjki.command.msg;

import org.seongjki.command.CommandArg;
import org.seongjki.user.User;

public class MessageArgs implements CommandArg {

    private String channelName;

    private String msg;

    private User requester;

    public MessageArgs(String channelName, String msg, User requester) {
        this.channelName = channelName;
        this.msg = msg;
        this.requester = requester;
    }

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
