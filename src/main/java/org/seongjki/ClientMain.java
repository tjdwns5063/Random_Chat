package org.seongjki;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 12345)) {
            System.out.println("Connected: " + socket);
            Scanner sc = new Scanner(System.in);

            DataInputStream is = new DataInputStream(socket.getInputStream());
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());

            while (true) {
                String input = sc.nextLine();

                System.out.println("input: " + input);
                os.writeUTF(input);
            }
        }
    }

}
