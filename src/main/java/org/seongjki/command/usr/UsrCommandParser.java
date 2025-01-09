package org.seongjki.command.usr;

import java.util.List;
import org.seongjki.command.CommandArg;
import org.seongjki.command.CommandParser;

public class UsrCommandParser extends CommandParser {

    private static final int ARG_SIZE = 4;

    @Override
    protected CommandArg parseImpl(List<String> args) {
        if (args.size() != ARG_SIZE)  {
            throw new IllegalArgumentException("올바른 인자를 입력해주세요");
        }

        return new UsrArgs(args.get(1), args.get(2), args.get(3));
    }
}
