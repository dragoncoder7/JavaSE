package DataStructureAndAlgorithm.LambdaDemo;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<Integer> predicate = a -> a > 50;
        System.out.println(predicate.test(52));
        IntPredicate intPredicate = a -> a > 50;
        IntStream.of(10, 11, 44, 59, 46, 55, 99, 88, 50).filter(intPredicate).peek(System.out::println).count();

    }
}
