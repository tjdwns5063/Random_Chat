package org.seongjki.channel;

import org.seongjki.command.join.JoinArgs;
import org.seongjki.user.User;

public class PublicChannel extends Channel {
    public PublicChannel(String name, Integer capacity) {
        super(name, capacity);
    }

    @Override
    public boolean join(JoinArgs arg, User user) {
        if (getParticipants().size() >= getCapacity()) {
            return false;
        }
        addUser(user);
        return true;
    }
}
