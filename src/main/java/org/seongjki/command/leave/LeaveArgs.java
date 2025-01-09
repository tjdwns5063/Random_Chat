package org.seongjki.command.leave;

import org.seongjki.command.CommandArg;
import org.seongjki.user.User;

public class LeaveArgs implements CommandArg {

    private String channelName;

    private Long requesterId;

    public LeaveArgs(Long requesterId, String channelName) {
        this.requesterId = requesterId;
        this.channelName = channelName;
    }

    public String getChannelName() {
        return channelName;
    }

    public Long getRequesterId() {
        return requesterId;
    }
}
