package LambdaDemo;

import java.util.Arrays;

public class LambdaTest {

    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();

        String salutation = "Hello";

        MathOperation addition = (int a, int b) -> a + b;

        MathOperation subtraction = (a, b) -> a - b;

        MathOperation multiplication = (int a, int b) -> {return  a * b;};

        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = "+lambdaTest.operate(10, 5, addition));

        System.out.println("10 - 5 = "+lambdaTest.operate(10,5, subtraction));

        System.out.println("10 * 5 = "+lambdaTest.operate(10,5, multiplication));

        System.out.println("10 / 5 = "+lambdaTest.operate(10,5, division));

        GreetingService greetingService = msg -> System.out.println("Hello" + msg);

        GreetingService greetingService1 = msg -> System.out.println("Hello" + msg);

        greetingService.sayMessage("shiyanlou");

        greetingService1.sayMessage("Classmate" + "");

        GreetingService greetingService2 = msg -> {System.out.println(salutation + msg);};

        greetingService2.sayMessage("shiyanlou");

        LambdaTest lambdaTest1 = new LambdaTest();

        int[] ints = {1, 23, 4, 4, 22, 34, 45, 11, 33};

        System.out.println(Arrays.stream(ints).min().getAsInt());

        System.out.println(Arrays.stream(ints).distinct().map(i -> i * 2).sum());

    }

    interface  MathOperation{
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String msg);
    }

    private  int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a ,b);
    }
}
