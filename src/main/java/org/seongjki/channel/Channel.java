package org.seongjki.channel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.seongjki.command.join.JoinArgs;
import org.seongjki.command.msg.MessageArgs;
import org.seongjki.user.User;

public abstract class Channel {

    private Long id;

    private String name;

    private Integer capacity;

    private List<User> participants = new ArrayList<>();

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

    public Channel(String name, Integer capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public abstract boolean join(JoinArgs arg, User user);

    public void addUser(User user) {
        getParticipants().add(user);
        user.getChannels().add(this);
    }

    public boolean sendMsg(MessageArgs args) {
        if (!isParticipate(args.getRequester())) {
            return false;
        }

        System.out.printf("%s [%s]: %s\n", FORMATTER.format(LocalDateTime.now()),
                args.getRequester().getNickname(), args.getMsg());
        return true;
    }

    private boolean isParticipate(User user) {
        return participants.stream().anyMatch(participant -> Objects.equals(user.getId(), participant.getId()));
    }
}
