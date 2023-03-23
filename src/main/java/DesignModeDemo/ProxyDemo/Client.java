package DesignModeDemo.ProxyDemo;

public class Client {
    public static void main(String[] args) {
        Subject proxy = new Proxy();
        proxy.build();
    }
}
