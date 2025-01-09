package org.seongjki.command.msg;

import java.util.List;
import org.seongjki.command.CommandArg;
import org.seongjki.command.CommandParser;

public class MessageCommandParser extends CommandParser {

    private static final int ARG_SIZE = 5;

    @Override
    protected CommandArg parseImpl(List<String> args) {
        if (args.size() != ARG_SIZE) {
            throw new IllegalArgumentException("올바른 인자를 입력해주세요");
        }

        return new MessageArgs(args.get(1), Long.parseLong(args.get(2)), args.get(3), args.get(4));
    }

}
