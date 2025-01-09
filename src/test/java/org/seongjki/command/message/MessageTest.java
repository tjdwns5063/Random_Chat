package org.seongjki.command.message;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.seongjki.channel.Channel;
import org.seongjki.channel.PublicChannel;
import org.seongjki.command.msg.Message;
import org.seongjki.command.msg.MessageArgs;
import org.seongjki.user.User;
import org.seongjki.user.storage.MemoryUserRepository;
import org.seongjki.user.storage.UserRepository;

public class MessageTest {

    private Message message;
    private UserRepository userRepository;
    private User user;
    private Channel channel;

    @BeforeEach
    public void init() {
        userRepository = new MemoryUserRepository();
        message = new Message(userRepository);
        user = new User(1L, "seongjki", "1234", "male");
        channel = new PublicChannel("test", 4);
        channel.getParticipants().add(user);
        user.getChannels().add(channel);
        userRepository.save(user);
    }

    @Test
    void 메세지_전송_성공() {
        //given
        MessageArgs msgArgs = new MessageArgs("c", user.getId(), "test", "hello");

        //when
        boolean result = message.execute(msgArgs);

        //then
        Assertions.assertTrue(result);
    }

    @Test
    void 메세지_전송_채널_존재X_실패() {
        //given
        MessageArgs msgArgs = new MessageArgs("c", user.getId(),"test2", "hello");

        //when
        boolean result = message.execute(msgArgs);

        //then
        Assertions.assertFalse(result);
    }

    @Test
    void 메시지_전송_채널에_유저_X_실패() {
        //given
        MessageArgs msgArgs = new MessageArgs("c", user.getId(), "test", "hello");
        channel.getParticipants().clear();

        //when
        boolean result = message.execute(msgArgs);

        //then
        Assertions.assertFalse(result);
    }

}
