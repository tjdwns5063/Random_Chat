package org.seongjki.channel;

import org.apache.commons.lang3.StringUtils;
import org.seongjki.command.join.JoinArgs;

public class PrivateChannel extends Channel {

    private String password;

    public PrivateChannel(String name, Integer capacity, String password) {
        super(name, capacity);
        this.password = password;
    }

    @Override
    public boolean join(JoinArgs arg) {
        if (getParticipants().size() >= getCapacity()) {
            return false;
        }
        if (!StringUtils.equals(password, arg.getPassword())) {
            return false;
        }
        arg.getRequester().getChannels().add(this);
        getParticipants().add(arg.getRequester());
        return true;
    }
}
