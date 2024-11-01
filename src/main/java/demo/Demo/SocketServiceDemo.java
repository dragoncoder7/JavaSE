package demo.Demo;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.Date;

public class SocketServiceDemo implements Runnable
{
    public static void main(String[] args) {
        try {
            InetAddress bindAddress = InetAddress.getByName("127.0.0.1");
            System.out.println(bindAddress.toString());
            ServerSocket serverSocket = new ServerSocket(9259,5,bindAddress);
            System.out.println(new Date());
            serverSocket.setSoTimeout(10000);
            serverSocket.accept();
            System.out.println("连接时间已到"+new Date());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void run(){
        System.out.println(" here ");
    }
}
