package org.seongjki.command.channel;

import org.apache.commons.lang3.StringUtils;
import org.seongjki.channel.Channel;
import org.seongjki.channel.PrivateChannel;
import org.seongjki.channel.PublicChannel;
import org.seongjki.channel.storage.ChannelRepository;
import org.seongjki.command.Command;
import org.seongjki.command.CommandArg;
import org.seongjki.user.User;
import org.seongjki.user.storage.UserRepository;

public class Ch implements Command {

    public static final String name = "CH";

    private final UserRepository userRepository;

    private final ChannelRepository channelRepository;

    public Ch(UserRepository userRepository, ChannelRepository channelRepository) {
        this.userRepository = userRepository;
        this.channelRepository = channelRepository;
    }

    @Override
    public boolean execute(CommandArg argument) {
        ChArgs args = (ChArgs) argument;
        User user = userRepository.findById(args.getRequesetId()).orElseThrow();

        if (channelRepository.isPresentByName(args.getName())) {
            System.out.println("이미 존재하는 채널 이름입니다.");
            return false;
        }

        Channel channel = createChannel(args);
        channelRepository.save(channel);
        channel.addUser(user);

        return true;
    }

    private Channel createChannel(ChArgs args) {
        if (StringUtils.isEmpty(args.getPassword())) {
            return new PublicChannel(args.getName(), args.getCapacity());
        }
        return new PrivateChannel(args.getName(),args.getCapacity(), args.getPassword());
    }

}
