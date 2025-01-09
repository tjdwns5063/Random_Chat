package org.seongjki.handler;

import org.seongjki.channel.storage.ChannelRepository;
import org.seongjki.command.Command;
import org.seongjki.command.CommandParser;
import org.seongjki.command.channel.Ch;
import org.seongjki.command.channel.ChCommandParser;
import org.seongjki.command.join.Join;
import org.seongjki.command.join.JoinCommandParser;
import org.seongjki.command.leave.Leave;
import org.seongjki.command.leave.LeaveCommandParser;
import org.seongjki.command.msg.Message;
import org.seongjki.command.msg.MessageCommandParser;
import org.seongjki.command.usr.Usr;
import org.seongjki.command.usr.UsrCommandParser;
import org.seongjki.user.storage.UserRepository;

public class ConsoleHandler implements Handler {

    private static final String SEPERATOR = ":";

    private final UserRepository userRepository;

    private final ChannelRepository channelRepository;

    public ConsoleHandler(UserRepository userRepository, ChannelRepository channelRepository) {
        this.userRepository = userRepository;
        this.channelRepository = channelRepository;
    }

    @Override
    public void handle(String input) {
        Command cmd = getCommand(input);
        CommandParser parser = getParser(input);

        cmd.execute(parser.parse(input));
    }

    private Command getCommand(String input) {
        String cmd = input.split(SEPERATOR)[0].toUpperCase().trim();

        return switch (cmd) {
            case Join.name -> new Join(userRepository, channelRepository);
            case Leave.name -> new Leave(userRepository);
            case Message.name -> new Message(userRepository);
            case Usr.name -> new Usr(userRepository);
            case Ch.name -> new Ch(userRepository, channelRepository);
            default -> throw new IllegalArgumentException("해당 커맨드가 존재하지 않습니다.");
        };
    }

    private CommandParser getParser(String input) {
        String cmd = input.split(SEPERATOR)[0].toUpperCase().trim();

        return switch (cmd) {
            case Join.name -> new JoinCommandParser();
            case Leave.name -> new LeaveCommandParser();
            case Message.name -> new MessageCommandParser();
            case Usr.name -> new UsrCommandParser();
            case Ch.name -> new ChCommandParser();
            default -> throw new IllegalArgumentException("해당 커맨드가 존재하지 않습니다.");
        };
    }
}
