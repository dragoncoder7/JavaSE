package LeetCode;

public class Solution12 {

    public static void main(String[] args) {

    }

    /**
     * 力扣344. 反转字符串
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     *
     * @param s 字符数组 s
     */
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length; i++) {
            int start = 0;
            char begin = s[i];

            char end = s[s.length - i - 1];
            exchange(begin, end);
            start++;
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
