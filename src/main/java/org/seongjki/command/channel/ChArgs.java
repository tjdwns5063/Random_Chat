package org.seongjki.command.channel;

import org.seongjki.command.CommandArg;

public class ChArgs implements CommandArg {

    private Long requesetId;

    private String name;

    private String password;

    private int capacity;

    public ChArgs(Long requesetId, String name, String password, int capacity) {
        this.requesetId = requesetId;
        this.name = name;
        this.password = password;
        this.capacity = capacity;
    }

    public Long getRequesetId() {
        return requesetId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getCapacity() {
        return capacity;
    }
}
