package org.seongjki.channel;

import org.apache.commons.lang3.StringUtils;

public class PrivateChannel extends Channel {

    private String password;

    public PrivateChannel(String name, Integer capacity, String password) {
        super(name, capacity);
        this.password = password;
    }
}
