package org.seongjki.command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.seongjki.channel.Channel;
import org.seongjki.channel.PrivateChannel;
import org.seongjki.channel.PublicChannel;
import org.seongjki.channel.storage.ChannelRepository;
import org.seongjki.channel.storage.MemoryChannelRepository;
import org.seongjki.command.join.Join;
import org.seongjki.command.join.JoinArgs;
import org.seongjki.user.User;

public class JoinTest {

    static Join join;

    static ChannelRepository channelRepository;

    @BeforeEach
    void beforeEach() {
        channelRepository = new MemoryChannelRepository();
        join = new Join(channelRepository);
    }

    @Test
    void 공개방_조인_성공() {
        //given
        User user = new User(1L, "seongjki", "1234", "male");
        Channel channel = new PublicChannel("test", 4);
        JoinArgs joinArgs = new JoinArgs(user, "test", null);
        channelRepository.save(channel);

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
        JoinArgs joinArgs = new JoinArgs(user, "test", "1234");
        channelRepository.save(channel);

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
        JoinArgs joinArgs = new JoinArgs(user, "test", "12534");
        channelRepository.save(channel);

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
        JoinArgs joinArgs = new JoinArgs(user, "test", "12534");
        channelRepository.save(channel);
        channel.getParticipants().add(new User(2L, "temp", "temp", "temp"));

        //when
        boolean result = join.execute(joinArgs);

        //then
        Assertions.assertFalse(result);
    }

}
