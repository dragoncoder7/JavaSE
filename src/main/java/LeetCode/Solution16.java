package LeetCode;

public class Solution16 {
    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        String s = "Let's take LeetCode contest";

        System.out.println(solution16.reverseWords(s));
    }

    /**
     * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     * @param s 字符串s
     * @return 返回字符串s中每个单词的字符顺序反转后的字符串
     */
    public String reverseWords(String s) {
        String[] string = s.split(" ");
        for (int i = 0; i < string.length; i++) {
            string[i] = new StringBuffer(string[i]).reverse().toString();
        }
        return String.join(" ", string);
    }
}
