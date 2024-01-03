package LeetCode;

public class Solution12 {

    public static void main(String[] args) {

    }
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length; i++) {
            int start = 0;
            int over = s.length-1;
            char begin = s[i];

            char end = s[s.length - i - 1];
            exchange(begin, end);
            start++;
            over--;
            if (start > end){
                break;
            }
        }
    }
    public void exchange(char a, char b){
        char c = a;
        a = b;
        b = c;
    }
}
