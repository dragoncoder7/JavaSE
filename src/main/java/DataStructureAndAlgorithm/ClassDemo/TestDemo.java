package DataStructureAndAlgorithm.ClassDemo;

public class TestDemo {
    public static void main(String[] args) {
        Test<Integer> test = new Test<>(100);
        test.showType();
        Test<String> stringTest = new Test<>("Stringtest");
        stringTest.showType();
        System.out.println(stringTest.getVar());
        System.out.println(test.getVar());
        Test<Animal> test1 =new Test<>();
        Dog dog = new Dog();
        Animal animal = new Animal();
        Animal animal1 = test1.testDemo(animal, dog);
        System.out.println(animal1.getClass().getName());

    }
}
