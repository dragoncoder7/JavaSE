package demo.Demo;

import java.io.IOException;
import java.net.Socket;

public class ClientSocketDemo {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",9259);
            System.out.println(socket);
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
