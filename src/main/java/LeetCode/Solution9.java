package LeetCode;

public class Solution9 {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        Solution9 solution9 = new Solution9();
        solution9.reverseString(s);
        System.out.println(s);
    }
    /**
     * 力扣344. 反转字符串
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     *
     * @param s 字符数组 s
     */
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
