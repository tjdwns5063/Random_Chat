package org.seongjki.command.join;

import org.seongjki.command.CommandArg;
import org.seongjki.user.User;

public class JoinArgs implements CommandArg {

    private Long requesterId;

    private String channelName;

    private String password;

    public JoinArgs(Long requesterId, String channelName, String password) {
        this.requesterId = requesterId;
        this.channelName = channelName;
        this.password = password;
    }

    public Long getRequesterId() {
        return requesterId;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getPassword() {
        return password;
    }

}
