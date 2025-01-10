package org.seongjki.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import org.seongjki.handler.Handler;

public class Client extends Thread {

    private final Socket socket;

    private final Handler handler;

    public Client(Socket socket, Handler handler) {
        this.socket = socket;
        this.handler = handler;
    }

    @Override
    public void run() {
        try {
            runImpl();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void runImpl() throws IOException {
        DataInputStream is = new DataInputStream(socket.getInputStream());
        DataOutputStream os = new DataOutputStream(socket.getOutputStream());

        while (true) {
            String request = is.readUTF();
            System.out.println(request);

            try {
                handler.handle(request);
            } catch (Exception  e) {
                System.out.println(e);
            }
        }
    }

}
