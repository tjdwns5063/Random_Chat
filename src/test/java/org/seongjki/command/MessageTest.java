package org.seongjki.command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.seongjki.channel.Channel;
import org.seongjki.channel.PublicChannel;
import org.seongjki.user.User;

public class MessageTest {

    static User user = new User(1L, "seongjki", "1234", "male");
    static Channel channel = new PublicChannel("test", 4);

    @BeforeAll
    public static void init() {
        channel.getParticipants().add(user);
        user.getChannels().add(channel);
    }

    @Test
    void 메세지_전송_성공() {
        //given
        Command message = new Message();
        MessageArgs msgArgs = new MessageArgs("test", "hello", user);

        //when
        boolean result = message.execute(msgArgs);

        //then
        Assertions.assertTrue(result);
    }

    @Test
    void 메세지_전송_채널_존재X_실패() {
        //given
        Command message = new Message();
        MessageArgs msgArgs = new MessageArgs("test2", "hello", user);

        //when
        boolean result = message.execute(msgArgs);

        //then
        Assertions.assertFalse(result);
    }

    @Test
    void 메시지_전송_채널에_유저_X_실패() {
        //given
        Command message = new Message();
        MessageArgs msgArgs = new MessageArgs("test", "hello", user);
        channel.getParticipants().clear();

        //when
        boolean result = message.execute(msgArgs);

        //then
        Assertions.assertFalse(result);
    }

}
