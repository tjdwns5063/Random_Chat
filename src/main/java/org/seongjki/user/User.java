package org.seongjki.user;

public class User {

    private Long id;

    private String nickname;

    private String password;

    private String gender;

    public User(Long id, String nickname, String password, String gender) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.gender = gender;
    }

}
