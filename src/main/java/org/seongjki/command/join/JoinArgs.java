package org.seongjki.command.join;

import java.util.List;
import org.seongjki.channel.Channel;
import org.seongjki.command.CommandArg;
import org.seongjki.user.User;

public class JoinArgs implements CommandArg {

    private User requester;

    private String channelName;

    private String password;

    public JoinArgs(User requester, String channelName, String password) {
        this.requester = requester;
        this.channelName = channelName;
        this.password = password;
    }

    public User getRequester() {
        return requester;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getPassword() {
        return password;
    }

}
