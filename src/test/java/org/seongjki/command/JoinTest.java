package org.seongjki.command;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.seongjki.channel.Channel;
import org.seongjki.channel.PrivateChannel;
import org.seongjki.channel.PublicChannel;
import org.seongjki.command.join.Join;
import org.seongjki.command.join.JoinArgs;
import org.seongjki.user.User;

public class JoinTest {

    @Test
    void 공개방_조인_성공() {
        //given
        User user = new User(1L, "seongjki", "1234", "male");
        Channel channel = new PublicChannel("test", 4);
        Command join = new Join();
        JoinArgs joinArgs = new JoinArgs(List.of(channel), user, "test", null);

        //when
        boolean result = join.execute(joinArgs);

        //then
        Assertions.assertTrue(result);
    }

    @Test
    void 비공개방_조인_성공() {
        //given
        User user = new User(1L, "seongjki", "1234", "male");
        Channel channel = new PrivateChannel("test", 4, "1234");
        Command join = new Join();
        JoinArgs joinArgs = new JoinArgs(List.of(channel), user, "test", "1234");

        //when
        boolean result = join.execute(joinArgs);

        //then
        Assertions.assertTrue(result);
    }

    @Test
    void 비공개방_조인_비밀번호_불일치_실패() {
        //given
        User user = new User(1L, "seongjki", "1234", "male");
        Channel channel = new PrivateChannel("test", 4, "1234");
        Command join = new Join();
        JoinArgs joinArgs = new JoinArgs(List.of(channel), user, "test", "12534");

        //when
        boolean result = join.execute(joinArgs);

        //then
        Assertions.assertFalse(result);
    }

    @Test
    void 조인_정원초과_실패() {
        //given
        User user = new User(1L, "seongjki", "1234", "male");
        Channel channel = new PrivateChannel("test", 1, "1234");
        Command join = new Join();
        JoinArgs joinArgs = new JoinArgs(List.of(channel), user, "test", "12534");

        channel.getParticipants().add(new User(2L, "temp", "temp", "temp"));

        //when
        boolean result = join.execute(joinArgs);

        //then
        Assertions.assertFalse(result);
    }

}
