package org.seongjki.command.msg;

import org.apache.commons.lang3.StringUtils;
import org.seongjki.channel.Channel;
import org.seongjki.command.Command;
import org.seongjki.command.CommandArg;
import org.seongjki.user.User;
import org.seongjki.user.storage.UserRepository;

public class Message implements Command {

    public static final String name = "MSG";

    private final UserRepository userRepository;

    public Message(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean execute(CommandArg argument) {
        validateArgs(argument);

        MessageArgs args = (MessageArgs) argument;

        User user = userRepository.findById(args.getRequesterId()).orElseThrow();

        Channel channel = user.getChannels().stream().filter(ch -> StringUtils.equals(ch.getName(), args.getChannelName()))
                .findFirst()
                .orElse(null);

        return channel != null && channel.sendMsg(args);
    }

    private void validateArgs(CommandArg argument) {
        if (!(argument instanceof MessageArgs)) {
            throw new IllegalArgumentException("명령의 인자가 올바르지 않습니다.");
        }
    }

}
