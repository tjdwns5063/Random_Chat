package org.seongjki.command.message;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.seongjki.channel.Channel;
import org.seongjki.channel.PublicChannel;
import org.seongjki.command.CommandArg;
import org.seongjki.command.msg.Message;
import org.seongjki.command.msg.MessageArgs;
import org.seongjki.command.msg.MessageCommandParser;
import org.seongjki.user.User;
import org.seongjki.user.storage.MemoryUserRepository;
import org.seongjki.user.storage.UserRepository;

public class MessageParserTest {

    private UserRepository userRepository;
    private Message msg;

    @BeforeEach
    void beforeEach() {
        userRepository = new MemoryUserRepository();
        msg = new Message(userRepository);
        User user =  new User(1L, "test", "1234", "male");
        Channel channel = new PublicChannel("test", 4);
        channel.addUser(user);
        userRepository.save(user);
    }

    @Test
    void 메세지_파싱_성공() {
        //given
        String cmd = "msg :c :1 :test :hello world!";
        MessageCommandParser parser = new MessageCommandParser();

        //when
        MessageArgs args = (MessageArgs) parser.parse(cmd);

        //then
        Assertions.assertEquals(new MessageArgs("c", 1L, "test", "hello world!"), args);
    }

}
