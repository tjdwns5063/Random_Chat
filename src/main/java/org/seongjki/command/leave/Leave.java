package org.seongjki.command.leave;

import org.apache.commons.lang3.StringUtils;
import org.seongjki.command.Command;
import org.seongjki.command.CommandArg;

public class Leave implements Command {

    @Override
    public boolean execute(CommandArg argument) {
        validateArgs(argument);

        LeaveArgs args = (LeaveArgs) argument;

        if (args.getRequester().getChannels().stream().noneMatch(ch -> StringUtils.equals(ch.getName(), args.getChannelName()))) {
            return false;
        }

        args.getRequester().getChannels().stream().filter(ch -> StringUtils.equals(ch.getName(), args.getChannelName())).findFirst()
                .ifPresent(ch -> {
                    ch.getParticipants().remove(args.getRequester());
                    args.getRequester().getChannels().remove(ch);
                });

        return true;
    }

    private void validateArgs(CommandArg argument) {
        if (!(argument instanceof LeaveArgs)) {
            throw new IllegalArgumentException("명령의 인자가 올바르지 않습니다.");
        }
    }

}
