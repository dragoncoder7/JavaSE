package Test;

import java.util.*;


public class test {
    public static void main(String[] args) throws InterruptedException {
        System.out.println();
    }

    /**
     * 可以利用双指针 一前一后 都遇到第一个元音了 就交换位置 就能很快的处理
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {
        char[] specials = new char[]{'a','e','i','o','u','A','E','I','O','U'};//
        List<Integer> list = new ArrayList<>();
        Set<Character> charSet = new HashSet<>();
        String ans;
        char[] words = s.toCharArray();
        for (char c :
                specials) {
            charSet.add(c);
        }
        for (int i = 0; i < words.length; i++) {
            if (charSet.contains(s.charAt(i))){
                list.add(i);
            }
        }
        char[] res = s.toCharArray();
        if (list.size() % 2 == 0){
            for (int i = 0; i < list.size() / 2; i++) {
                swap(res, list.get(i), list.get(list.size() - 1 - i));
            }
            ans = String.valueOf(res);
        } else {
            for (int i = 0; i < list.size() / 2 + 1; i++) {
                swap(res, list.get(i), list.get(list.size() - 1 - i));

            }
            ans = String.valueOf(res);
        }
        return ans;
    }
    public static void swap(char[] res, int a, int b){
        char temp = res[a];
        res[a]= res[b];
        res[b] = temp;
    }

    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public int[] productExceptSelf(int[] nums) {
        return null;
    }
}
