package LeetCode.LeetCode75.Stack;

import java.util.Stack;

public class leetcode24 {
    public static void main(String[] args) {
        leetcode24 leetcode24 = new leetcode24();
        System.out.println(leetcode24.removeStars("leet**cod*e"));
    }
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c :
                s.toCharArray()) {
            if (c == '*'){
                sb.deleteCharAt(sb.length()-1);
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
