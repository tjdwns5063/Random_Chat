package org.seongjki.channel;

import org.apache.commons.lang3.StringUtils;
import org.seongjki.command.join.JoinArgs;
import org.seongjki.user.User;

public class PrivateChannel extends Channel {

    private String password;

    public PrivateChannel(String name, Integer capacity, String password) {
        super(name, capacity);
        this.password = password;
    }

    @Override
    public boolean join(JoinArgs arg, User user) {
        if (getParticipants().size() >= getCapacity()) {
            return false;
        }
        if (!StringUtils.equals(password, arg.getPassword())) {
            return false;
        }
        addUser(user);
        return true;
    }
}
