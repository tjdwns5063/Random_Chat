package org.seongjki.command.join;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.seongjki.channel.Channel;
import org.seongjki.channel.storage.ChannelRepository;
import org.seongjki.command.Command;
import org.seongjki.command.CommandArg;
import org.seongjki.user.User;
import org.seongjki.user.storage.UserRepository;

public class Join implements Command {

    public final static String name = "JOIN";

    private final UserRepository userRepository;

    private final ChannelRepository channelRepository;

    public Join(UserRepository userRepository, ChannelRepository channelRepository) {
        this.userRepository = userRepository;
        this.channelRepository = channelRepository;
    }

    @Override
    public boolean execute(CommandArg argument) {
        validateArgs(argument);

        JoinArgs args = (JoinArgs) argument;

        List<Channel> channels = channelRepository.findAll();
        User user = userRepository.findById(args.getRequesterId()).orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));
        Channel channel = channels.stream().filter(ch -> StringUtils.equals(ch.getName(), args.getChannelName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 채널이 존재하지 않습니다."));

        return channel.join(args, user);
    }

    private void validateArgs(CommandArg argument) {
        if (!(argument instanceof JoinArgs)) {
            throw new IllegalArgumentException("명령의 인자가 올바르지 않습니다.");
        }
    }

}
