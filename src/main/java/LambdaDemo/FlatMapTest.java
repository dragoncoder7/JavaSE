package LambdaDemo;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMapTest {
    public static void main(String[] args) {
        Stream<String> StringStream1 = Stream.of("shi yan","shi yan lou ", "lou yan shi");
        Stream<String> StringStream2 = Stream.of("shi yan","shi yan lou ", "lou yan shi");

        Stream<String[]> mapStream = StringStream1.map(v -> v.split(" "));
        Stream<String> flatMapStream = StringStream2.flatMap(v -> Arrays.stream(v.split(" ")));
        System.out.println(flatMapStream);
        mapStream.peek(System.out::println).count();
        System.out.println();
        flatMapStream.peek(System.out::println).count();
    }
}
