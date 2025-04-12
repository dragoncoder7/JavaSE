package LeetCode.LeetCode75.DynamicProgramming;

import java.util.*;

public class leetcode61 {
    public static void main(String[] args) {
        leetcode61 leetcode61 = new leetcode61();
        System.out.println(leetcode61.numTilings(2));
        System.out.println();
        HashMap<String, String> map = new HashMap<>();
        System.out.println("第一次"+map.put("1", "1"));
        System.out.println("第二次"+map.put("1", "1"));
        System.out.println("第一次"+map.remove("1"));
        System.out.println("第二次"+map.remove("1"));


        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");
        map.put("6", "6");
        map.put("7", "7");

        //方式1 map.entrySet() 键值对的一个Set集合
        System.out.println("方式1");
        for (Map.Entry<String, String> entry : map.entrySet()
             ) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key);
            System.out.println(value);
        }

        //方式2 map.keySet() 键的一个Set集合
        System.out.println("方式2");
        Set<String> strings = map.keySet();
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.forEach(System.out::println);
        set.add(1);
        for (String string : strings) {
            System.out.println(string);
            System.out.println(map.get(string));
        }

        //方式3 map.values() 值的一个Collection集合
        System.out.println("方式3");
        Collection<String> values = map.values();
        for (String value : values) {
            System.out.println(value);
        }


        //方式4 map.entrySet().iterator() iterator遍历
        System.out.println("iterator方式4");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }



        // 单线程遍历
        System.out.println("方式5单线程");
        long now = System.currentTimeMillis();
        System.out.println(now);
        map.forEach(
                (k, v) -> System.out.println("key: " + k + " value:" + v)
        );
        System.out.println(System.currentTimeMillis() - now);

        System.out.println("方式6多线程");
        long now1 = System.currentTimeMillis();
        map.entrySet().parallelStream().forEach(
                (entry) -> System.out.println("key: " + entry.getKey() + " value:" + entry.getValue()
        ));
        System.out.println(System.currentTimeMillis() - now1);

        //方式6 map.entrySet().stream().parallel() parallelStream多线程遍历
        map.entrySet().stream().parallel().forEach(entry -> System.out.println("key: " + entry.getKey() + " value:" + entry.getValue()));

        //方式1
        map.forEach((k, v) -> System.out.println("key: " + k + " value:" + v));

    }

    public int numTilings(int n) {
        return n * n;
    }
}
