package org.seongjki.channel;

import org.seongjki.command.join.JoinArgs;

public class PublicChannel extends Channel {
    public PublicChannel(String name, Integer capacity) {
        super(name, capacity);
    }

    @Override
    public boolean join(JoinArgs arg) {
        if (getParticipants().size() >= getCapacity()) {
            return false;
        }
        arg.getRequester().getChannels().add(this);
        getParticipants().add(arg.getRequester());
        return true;
    }
}
