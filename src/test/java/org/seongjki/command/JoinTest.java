package org.seongjki.command;

import org.junit.jupiter.api.Assertions;
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
import org.seongjki.user.storage.MemoryUserRepository;
import org.seongjki.user.storage.UserRepository;

public class JoinTest {

    static Join join;

    static ChannelRepository channelRepository;

    static UserRepository userRepository;

    static User user;

    @BeforeEach
    void beforeEach() {
        channelRepository = new MemoryChannelRepository();
        userRepository = new MemoryUserRepository();
        join = new Join(userRepository, channelRepository);
        user = new User(1L, "seongjki", "1234", "male");
        userRepository.save(user);
    }

    @Test
    void 공개방_조인_성공() {
        //given
        Channel channel = new PublicChannel("test", 4);
        JoinArgs joinArgs = new JoinArgs(user.getId(),"test", null);
        channelRepository.save(channel);

        //when
        boolean result = join.execute(joinArgs);

        //then
        Assertions.assertTrue(result);
    }

    @Test
    void 비공개방_조인_성공() {
        //given
        Channel channel = new PrivateChannel("test", 4, "1234");
        JoinArgs joinArgs = new JoinArgs(user.getId(),"test", "1234");
        channelRepository.save(channel);

        //when
        boolean result = join.execute(joinArgs);

        //then
        Assertions.assertTrue(result);
    }

    @Test
    void 비공개방_조인_비밀번호_불일치_실패() {
        //given
        Channel channel = new PrivateChannel("test", 4, "1234");
        JoinArgs joinArgs = new JoinArgs(user.getId(), "test", "12534");
        channelRepository.save(channel);

        //when
        boolean result = join.execute(joinArgs);

        //then
        Assertions.assertFalse(result);
    }

    @Test
    void 조인_정원초과_실패() {
        //given
        Channel channel = new PrivateChannel("test", 1, "1234");
        JoinArgs joinArgs = new JoinArgs(user.getId(), "test", "12534");
        channelRepository.save(channel);
        channel.getParticipants().add(new User(2L, "temp", "temp", "temp"));

        //when
        boolean result = join.execute(joinArgs);

        //then
        Assertions.assertFalse(result);
    }

}
