package org.seongjki.command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.seongjki.channel.Channel;
import org.seongjki.channel.PublicChannel;
import org.seongjki.command.leave.Leave;
import org.seongjki.command.leave.LeaveArgs;
import org.seongjki.user.User;
import org.seongjki.user.storage.MemoryUserRepository;
import org.seongjki.user.storage.UserRepository;

public class LeaveTest {

    static Leave leave;

    static UserRepository userRepository;

    static User user;

    static Channel channel;

    @BeforeEach
    void beforeAll() {
        userRepository  = new MemoryUserRepository();
        leave = new Leave(userRepository);
        user = new User(1L, "test", "test", "test");
        channel = new PublicChannel("test", 4);

        user.getChannels().add(channel);
        channel.getParticipants().add(user);
        userRepository.save(user);
    }

    @Test
    void 채널_나가기_성공() {
        //given
        LeaveArgs leaveArgs = new LeaveArgs(user.getId(), "test");

        //when
        boolean result = leave.execute(leaveArgs);

        //then
        Assertions.assertTrue(result);
        Assertions.assertTrue(user.getChannels().isEmpty());
        Assertions.assertTrue(channel.getParticipants().isEmpty());
    }

    @Test
    void 채널_나가기_실패() {
        //given
        LeaveArgs leaveArgs = new LeaveArgs(user.getId(), "test2");

        //when
        boolean result = leave.execute(leaveArgs);

        //then
        Assertions.assertFalse(result);
    }

}
