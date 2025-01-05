package org.seongjki.user;

import java.util.ArrayList;
import java.util.List;
import org.seongjki.channel.Channel;

public class User {

    private Long id;

    private String nickname;

    private String password;

    private String gender;

    private List<Channel> channels = new ArrayList<>();

    public User(Long id, String nickname, String password, String gender) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public List<Channel> getChannels() {
        return channels;
    }
}
