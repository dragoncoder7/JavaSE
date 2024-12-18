package LeetCode.LeetCode75;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class leetcode15 {
    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder("abciiidef".substring(0,3));
//        sb.append("abciiidef".charAt(4));
//        sb.delete(0,1);
//
//        //System.out.println(sb);
//        System.out.println(sb);
        leetcode15 leetcode15 = new leetcode15();
        //leetcode15.countAEIOU(sb);
        System.out.println(leetcode15.maxVowels("abciiidef",3));
        System.out.println("aeiou".indexOf('a'));
    }
    public int maxVowels(String s, int k) {
        int n = s.length();
        int vowel_count = 0;
        for (int i = 0; i < k; ++i) {
            vowel_count += isVowel(s.charAt(i));
        }
        int ans = vowel_count;
        for (int i = k; i < n; ++i) {
            vowel_count += isVowel(s.charAt(i)) - isVowel(s.charAt(i - k));
            ans = Math.max(ans, vowel_count);
        }
        return ans;
    }

    public int isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ? 1 : 0;
    }

//    public int countAEIOU(StringBuilder sb){
//        int count = 0;
//        // 匹配元音字母（大小写均匹配）
//        Pattern pattern = Pattern.compile("[aeiouAEIOU]");
//        Matcher matcher = pattern.matcher(sb);
//
//        while (matcher.find()) {
//            count++;
//        }
//        System.out.println(count);
//        return count;
//    }

    public int countAEIOU(StringBuilder sb){
        int count = 0;

        for (char c : sb.toString().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) { // 判断是否是元音字母
                count++;
            }
        }
        //System.out.println(count);
        return count;
    }


}
