package ClassDemo;

public class Dog extends Animal{
    @Override
    public void bark() {
        System.out.println("狗叫");
    }

    public Dog() {
        System.out.println("I'm dog!");
    }
}
