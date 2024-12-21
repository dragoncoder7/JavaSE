package LeetCode.LeetCode75.HashTableOrHashCollections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class leetcode22 {
    public static void main(String[] args) {
        leetcode22 leetcode22 = new leetcode22();
        System.out.println(leetcode22.closeStrings("cabbba","abbccc"));
    }
    public boolean closeStrings(String word1, String word2) {
        HashMap<Character,Integer> hashMap1 = new HashMap<>();
        HashSet<Integer> hashSet1 = new HashSet<>();
        HashMap<Character,Integer> hashMap2 = new HashMap<>();
        HashSet<Integer> hashSet2 = new HashSet<>();
        for (char i : word1.toCharArray()) {
            hashMap1.merge(i,1,Integer::sum);
        }
        for (char i : word2.toCharArray()) {
            hashMap2.merge(i,1,Integer::sum);
        }
        for (Map.Entry<Character,Integer> entry: hashMap1.entrySet()) {
            hashSet1.add(entry.getValue());
        }
        for (Map.Entry<Character,Integer> entry: hashMap2.entrySet()) {
            hashSet2.add(entry.getValue());
        }
        return hashSet1.size() == hashSet2.size();
    }

}
