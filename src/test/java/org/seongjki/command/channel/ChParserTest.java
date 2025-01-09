package org.seongjki.command.channel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChParserTest {

    @Test
    void 공개채널_파싱_테스트() {
        //given
        ChCommandParser parser = new ChCommandParser();
        String cmd = "ch :1 :test : :4";

        //when
        ChArgs args = (ChArgs) parser.parse(cmd);

        //then
        Assertions.assertEquals(args.getName(), "test");
        Assertions.assertEquals(args.getPassword(), "");
        Assertions.assertEquals(args.getCapacity(), 4);
    }

    @Test
    void 비공개채널_파싱_테스트() {
        //given
        ChCommandParser parser = new ChCommandParser();
        String cmd = "ch :1 :test :1234 :4";

        //when
        ChArgs args = (ChArgs) parser.parse(cmd);

        //then
        Assertions.assertEquals(args.getName(), "test");
        Assertions.assertEquals(args.getPassword(), "1234");
        Assertions.assertEquals(args.getCapacity(), 4);
    }

}
