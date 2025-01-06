package org.seongjki.command.usr;

import org.seongjki.command.Command;
import org.seongjki.command.CommandArg;
import org.seongjki.user.User;
import org.seongjki.user.storage.UserRepository;

public class Usr implements Command {

    private final UserRepository userRepository;

    public Usr(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean execute(CommandArg argument) {
        validateArgs(argument);

        UsrArgs args = (UsrArgs) argument;
        userRepository.save(User.from(args));

        return true;
    }

    private void validateArgs(CommandArg argument) {
        if (!(argument instanceof UsrArgs)) {
            throw new IllegalArgumentException("명령의 인자가 올바르지 않습니다.");
        }
    }

}
