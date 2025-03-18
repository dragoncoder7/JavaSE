package DataStructureAndAlgorithm.ClassDemo;

public class Dog extends Animal implements interface2{
    @Override
    public void bark() {
        System.out.println("狗叫");
    }

    public Dog() {
        System.out.println("I'm dog!");
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.method1();
        dog.method2();
        dog.method11();
    }


    @Override
    public void method22() {

    }

    @Override
    public void method2() {

    }

    @Override
    public void method3() {

    }
}
