package AssembliesDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(75);
        list.add(55);
        list.add(43);
        list.add(135);
        list.add(54);
        list.forEach(v -> System.out.print(v + "\t"));
        System.out.println();
        Collections.shuffle(list);
        list.forEach(v -> System.out.print(v + "\t"));
        System.out.println();
        Collections.reverse(list);
        list.forEach(v -> System.out.print(v + "\t"));
        System.out.println();
        Collections.swap(list,0,list.size()-1);
        list.forEach(v -> System.out.print(v + "\t"));
        System.out.println();
        Collections.sort(list);
        list.forEach(v -> System.out.print(v + "\t"));
        System.out.println();
        System.out.println(Collections.binarySearch(list,55));
        List<Integer> integerList = Collections.synchronizedList(list);
        System.out.println(integerList);
    }
}
