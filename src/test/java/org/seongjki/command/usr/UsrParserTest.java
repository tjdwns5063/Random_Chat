package org.seongjki.command.usr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.seongjki.command.CommandArg;
import org.seongjki.user.storage.MemoryUserRepository;
import org.seongjki.user.storage.UserRepository;

public class UsrParserTest {
    UsrCommandParser usrCommandParser = new UsrCommandParser();
    static UserRepository userRepository;
    static Usr usr;

    @BeforeEach
    void beforeEach() {
        userRepository = new MemoryUserRepository();
        usr = new Usr(userRepository);
    }

    @Test
    void 유저_파싱_테스트() {
        //given
        String cmd = "user :seongjki :1234 :male";

        //when
        CommandArg args = usrCommandParser.parse(cmd);
        usr.execute(args);

        //then
        Assertions.assertEquals(userRepository.findAll().get(0).getNickname(), "seongjki");
        Assertions.assertEquals(userRepository.findAll().get(0).getPassword(), "1234");
        Assertions.assertEquals(userRepository.findAll().get(0).getGender(), "male");
    }

    @Test
    void 유저_파싱_실패_테스트() {
        //given
        String cmd = "user :seongjki";

        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> usrCommandParser.parse(cmd));
    }

}
