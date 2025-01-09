package org.seongjki;

import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;
import org.seongjki.channel.storage.ChannelRepository;
import org.seongjki.channel.storage.MemoryChannelRepository;
import org.seongjki.handler.ConsoleHandler;
import org.seongjki.user.storage.MemoryUserRepository;
import org.seongjki.user.storage.UserRepository;

public class Main {
    static UserRepository userRepository = new MemoryUserRepository();
    static ChannelRepository channelRepository = new MemoryChannelRepository();
    static ConsoleHandler handler = new ConsoleHandler(userRepository, channelRepository);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("input: ");
            String input = scanner.nextLine();

            if (StringUtils.equalsIgnoreCase(input, "exit")) {
                break ;
            }

            handler.handle(input);
        }
    }
}