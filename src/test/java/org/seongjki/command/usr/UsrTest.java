package org.seongjki.command.usr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.seongjki.command.msg.MessageArgs;
import org.seongjki.user.storage.MemoryUserRepository;
import org.seongjki.user.storage.UserRepository;

public class UsrTest {

    private UserRepository repository;

    @BeforeEach
    void beforeEach() {
        repository = new MemoryUserRepository();
    }

    @Test
    void 유저_생성_성공() {
        //given
        Usr usr = new Usr(repository);
        UsrArgs args = new UsrArgs("seongjki", "qwer", "male");

        //when
        boolean result = usr.execute(args);

        //then
        Assertions.assertTrue(result);
    }

    @Test
    void 유저_생성_실패_잘못된_인자() {
        //given
        Usr usr = new Usr(repository);
        MessageArgs args = new MessageArgs("c", 2L, "test2", "qwer");

        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> usr.execute(args));
    }

}
