package org.seongjki.command;

import org.apache.commons.lang3.StringUtils;
import org.seongjki.channel.Channel;
import org.seongjki.user.User;

public class Message implements Command {

    @Override
    public boolean execute(CommandArg argument) {
        validateArgs(argument);

        MessageArgs args = (MessageArgs) argument;

        User requester = args.getRequester();

        Channel channel = requester.getChannels().stream().filter(ch -> StringUtils.equals(ch.getName(), args.getChannelName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 채널이 존재하지 않습니다."));

        return channel.sendMsg(args);
    }

    private void validateArgs(CommandArg argument) {
        if (!(argument instanceof MessageArgs)) {
            throw new IllegalArgumentException("명령의 인자가 올바르지 않습니다.");
        }
    }

}
