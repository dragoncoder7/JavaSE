package LeetCode.LeetCode75.HashTableOrHashCollections;

import java.util.*;

public class leetcode21 {
    public static void main(String[] args) {
        leetcode21 leetcode21 = new leetcode21();
        System.out.println(leetcode21.uniqueOccurrences(new int[]{1,2}));
    }
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : arr) {
            hashMap.merge(i,1,Integer::sum);
        }
        for (Map.Entry<Integer,Integer> entry: hashMap.entrySet()) {
            hashSet.add(entry.getValue());
        }
        return hashSet.size() == hashMap.size();
    }
}
