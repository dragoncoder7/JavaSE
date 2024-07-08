package DataStructureAndAlgorithm.LambdaDemo;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
        List<Integer> list = Arrays.asList(2, 3, 3, 2, 5, 2, 7);
        List<Integer> squarelist = list.stream().map( i -> i * i).distinct().collect(Collectors.toList());
        List<String> strings = Arrays.asList("efg", "", "abc", "bc", "which","", "lmn");
//get count of empty string
        long count = strings.stream().filter(String::isEmpty).count();
        System.out.println(squarelist);
        System.out.println(count);
        random.ints().limit(5).sorted().forEach(System.out::println);
        count = strings.parallelStream().filter(String::isEmpty).count();
        System.out.println(count);
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(","));
        System.out.println(mergedString);
        IntSummaryStatistics statistics = list.stream().distinct().mapToInt(x -> x).summaryStatistics();
        System.out.println(statistics.getMax());
        System.out.println(statistics);
    }
}
