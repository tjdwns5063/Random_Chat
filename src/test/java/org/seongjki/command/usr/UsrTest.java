package org.seongjki.command.usr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.seongjki.command.msg.MessageArgs;
import org.seongjki.user.User;
import org.seongjki.user.storage.MemoryUserRepository;
import org.seongjki.user.storage.UserRepository;

public class UsrTest {

    static UserRepository repository;

    @BeforeAll
    static void beforeAll() {
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
        MessageArgs args = new MessageArgs("seongjki", "qwer", new User(1L, "test", "test", "test"));

        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> usr.execute(args));
    }

}
