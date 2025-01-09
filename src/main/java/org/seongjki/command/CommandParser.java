package org.seongjki.command;

import java.util.Arrays;
import java.util.List;

public abstract class CommandParser {

    public final CommandArg parse(String input) {
        List<String> args = Arrays.stream(input.split(":")).map(String::trim).toList();

        return parseImpl(args);
    }

    protected abstract CommandArg parseImpl(List<String> args);

}
