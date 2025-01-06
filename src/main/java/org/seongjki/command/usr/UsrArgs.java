package org.seongjki.command.usr;

import org.seongjki.command.CommandArg;

public class UsrArgs implements CommandArg {

    private String nickname;

    private String password;

    private String gender;

    public UsrArgs(String nickname, String password, String gender) {
        this.nickname = nickname;
        this.password = password;
        this.gender = gender;
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
}
