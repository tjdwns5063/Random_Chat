package org.seongjki;

import java.io.*;
import java.net.ServerSocket;
import org.seongjki.channel.storage.ChannelRepository;
import org.seongjki.channel.storage.MemoryChannelRepository;
import org.seongjki.client.Client;
import org.seongjki.handler.ConsoleHandler;
import org.seongjki.user.storage.MemoryUserRepository;
import org.seongjki.user.storage.UserRepository;

public class Main {
    static UserRepository userRepository = new MemoryUserRepository();
    static ChannelRepository channelRepository = new MemoryChannelRepository();
    static ConsoleHandler handler = new ConsoleHandler(userRepository, channelRepository);

    public static void main(String[] args) throws IOException {
        System.out.println("Server Runned");

        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            while (true) {
                Client client = new Client(serverSocket.accept(), handler);

                client.start();
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

}