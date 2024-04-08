package LeetCode;

public class Solution18 {
    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
        System.out.println(solution18.mergeAlternately("ab", "pqrs"));
    }
    public String mergeAlternately(String word1, String word2) {
        int minLength = Math.min(word1.length(),word2.length());
        int maxLength = Math.max(word1.length(),word2.length());
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            char[] c1 = word1.toCharArray();
            char[] c2 = word2.toCharArray();
            ans.append(c1[i]);
            ans.append(c2[i]);
        }
        String longWords = word1.length() > word2.length() ? word1 : word2;
        ans.append(longWords, minLength, maxLength);
        return ans.toString();
    }
}
