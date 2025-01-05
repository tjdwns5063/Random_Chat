package org.seongjki.channel;

import java.util.ArrayList;
import java.util.List;
import org.seongjki.user.User;

public abstract class Channel {

    private String name;

    private Integer capacity;

    private List<User> participants = new ArrayList<>();

    public Channel(String name, Integer capacity) {
        this.name = name;
        this.capacity = capacity;
    }

}
