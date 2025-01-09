package org.seongjki.command.leave;

import org.apache.commons.lang3.StringUtils;
import org.seongjki.command.Command;
import org.seongjki.command.CommandArg;
import org.seongjki.user.User;
import org.seongjki.user.storage.UserRepository;

public class Leave implements Command {

    public static final String name = "LEAVE";

    private final UserRepository userRepository;

    public Leave(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean execute(CommandArg argument) {
        validateArgs(argument);

        LeaveArgs args = (LeaveArgs) argument;
        User user = userRepository.findById(args.getRequesterId()).orElseThrow();

        if (user.getChannels().stream().noneMatch(ch -> StringUtils.equals(ch.getName(), args.getChannelName()))) {
            return false;
        }

        user.getChannels().stream().filter(ch -> StringUtils.equals(ch.getName(), args.getChannelName())).findFirst()
                .ifPresent(ch -> {
                    ch.getParticipants().remove(user);
                    user.getChannels().remove(ch);
                });

        return true;
    }

    private void validateArgs(CommandArg argument) {
        if (!(argument instanceof LeaveArgs)) {
            throw new IllegalArgumentException("명령의 인자가 올바르지 않습니다.");
        }
    }

}
