package LeetCode;

public class Solution9 {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        Solution9 solution9 = new Solution9();
        solution9.reverseString(s);
        System.out.println(s);
    }
    public void reverseString(char[] s) {
        int n = 0;
        int m = s.length - 1;
        for (int i = 0; i < s.length - i - 1; i++) {
            exchange(n,m,s);
            n++;
            m--;
            if (n > m || n == m){
                break;
            }
        }
    }
    public void exchange(int a, int b, char[] chars){
        char c = chars[a];
        chars[a] = chars[b];
        chars[b] = c;
    }
}
