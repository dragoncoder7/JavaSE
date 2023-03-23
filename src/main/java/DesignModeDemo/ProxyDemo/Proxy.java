package DesignModeDemo.ProxyDemo;

public class Proxy implements Subject{
    private Subject target;

    public Proxy() {
        this.target = new RealSubject();
    }

    @Override
    public void build() {
        System.out.println("buy materials");
        target.build();
        System.out.println("arrive top");
    }
}
