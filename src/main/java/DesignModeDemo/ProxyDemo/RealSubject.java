package DesignModeDemo.ProxyDemo;

public class RealSubject implements Subject{
    @Override
    public void build() {
        System.out.println("building Laboratory Building");
    }
}
