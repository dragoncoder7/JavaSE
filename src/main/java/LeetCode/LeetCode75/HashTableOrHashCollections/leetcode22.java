package LeetCode.LeetCode75.HashTableOrHashCollections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode22 {
    public static void main(String[] args) {
        leetcode22 leetcode22 = new leetcode22();
        System.out.println(leetcode22.closeStrings("aaabbbbccddeeeeefffff","aaaaabbcccdddeeeeffff"));
    }
    public boolean closeStrings(String word1, String word2) {
        HashMap<Character,Integer> hashMap1 = new HashMap<>();

        HashMap<Character,Integer> hashMap2 = new HashMap<>();

        for (char i : word1.toCharArray()) {
            hashMap1.merge(i,1,Integer::sum);
        }
        for (char i : word2.toCharArray()) {
            hashMap2.merge(i,1,Integer::sum);
        }
        if (!hashMap1.keySet().equals(hashMap2.keySet())){
            return false;
        }


        int[] a = new int[hashMap1.size()];
        int[] b = new int[hashMap1.size()];
        int i = 0;int j = 0;

        //
        for (Map.Entry<Character,Integer> entry: hashMap1.entrySet()) {
            a[i++] = entry.getValue();
        }
        for (Map.Entry<Character,Integer> entry: hashMap2.entrySet()) {
            b[j++] = entry.getValue();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    /**
     * leetcode参考答案
     * @param word1
     * @param word2
     * @return
     */
    public boolean closeStrings1(String word1, String word2) {
        int[] count1 = new int[26], count2 = new int[26];
        //统计每个字符表中不同字符的数量
        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
        }

        //如果有的字符表有某个字符 而另一个没有 直接返回false 等同于我自己写的  if (!hashMap1.keySet().equals(hashMap2.keySet())){return false;}
        for (int i = 0; i < 26; i++) {
            if (count1[i] > 0 && count2[i] == 0 || count1[i] == 0 && count2[i] > 0) {
                return false;
            }
        }
        //排序
        Arrays.sort(count1);
        Arrays.sort(count2);
        //数组完全一致就说明接近 可以由a字符串变为b字符串
        return Arrays.equals(count1, count2);
    }

}
