package org.seongjki.command.leave;

import org.seongjki.command.CommandArg;
import org.seongjki.user.User;

public class LeaveArgs implements CommandArg {

    private String channelName;

    private User requester;

    public LeaveArgs(User requester, String channelName) {
        this.requester = requester;
        this.channelName = channelName;
    }

    public String getChannelName() {
        return channelName;
    }

    public User getRequester() {
        return requester;
    }
}
