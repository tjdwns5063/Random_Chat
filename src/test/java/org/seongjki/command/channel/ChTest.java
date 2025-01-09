package org.seongjki.command.channel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.seongjki.channel.PrivateChannel;
import org.seongjki.channel.PublicChannel;
import org.seongjki.channel.storage.ChannelRepository;
import org.seongjki.channel.storage.MemoryChannelRepository;
import org.seongjki.user.User;
import org.seongjki.user.storage.MemoryUserRepository;
import org.seongjki.user.storage.UserRepository;

public class ChTest {

    private ChannelRepository channelRepository;

    private UserRepository userRepository;

    private User user;

    @BeforeEach
    void beforeEach() {
        channelRepository = new MemoryChannelRepository();
        userRepository = new MemoryUserRepository();
        user = new User(0L, "test", "test", "male");
        userRepository.save(user);
    }

    @Test
    void 공개_채널_생성_성공() {
        //given
        Ch ch = new Ch(userRepository, channelRepository);
        ChArgs chArgs = new ChArgs(user.getId(), "test", null, 4);

        //when
        boolean result = ch.execute(chArgs);

        //then
        Assertions.assertTrue(result);
        Assertions.assertEquals(channelRepository.findByName("test").get().getClass(), PublicChannel.class);
    }

    @Test
    void 비공개_채널_생성_성공() {
        //given
        Ch ch = new Ch(userRepository, channelRepository);
        ChArgs chArgs = new ChArgs(user.getId(), "test", "1234", 4);

        //when
        boolean result = ch.execute(chArgs);

        //then
        Assertions.assertTrue(result);
        Assertions.assertEquals(channelRepository.findByName("test").get().getClass(), PrivateChannel.class);
    }

}
