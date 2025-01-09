package org.seongjki.command.leave;

import java.util.List;
import org.seongjki.command.CommandArg;
import org.seongjki.command.CommandParser;

public class LeaveCommandParser extends CommandParser {

    private static final int ARG_SIZE = 3;

    @Override
    protected CommandArg parseImpl(List<String> args) {
        if (ARG_SIZE != args.size()) {
            throw new IllegalArgumentException("올바른 인자를 입력해주세요");
        }

        return new LeaveArgs(Long.parseLong(args.get(1)), args.get(2));
    }
}
