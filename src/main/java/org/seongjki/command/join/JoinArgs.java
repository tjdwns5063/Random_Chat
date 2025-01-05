package org.seongjki.command.join;

import java.util.List;
import org.seongjki.channel.Channel;
import org.seongjki.command.CommandArg;
import org.seongjki.user.User;

public class JoinArgs implements CommandArg {

    private List<Channel> channels;

    private User requester;

    private String channelName;

    private String password;

    public JoinArgs(List<Channel> channels, User requester, String channelName, String password) {
        this.channels = channels;
        this.requester = requester;
        this.channelName = channelName;
        this.password = password;
    }

    public List<Channel> getChannels() {
        return channels;
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
