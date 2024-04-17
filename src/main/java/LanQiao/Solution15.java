package LanQiao;

public class Solution15 {
    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        System.out.println(solution15.findTheDifference("abcd","abd"));
    }
    public char findTheDifference(String s, String t) {
        int as = 0;
        int at = 0;
        for (int i = 0; i < s.length(); i++) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            at += t.charAt(i);
        }
        return (char)(at - as);
    }
}
