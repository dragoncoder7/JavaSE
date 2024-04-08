package LeetCode;

import java.util.Arrays;

public class Solution22 {
    public static void main(String[] args) {
        /* 这里输入您的代码 */
        int[] digits = {5,6,2,0,0,4,6,2,4,9};
        int[] res = plusOne(digits);
        System.out.println(Arrays.toString(res));
    }
    // 请在这里定义您需要的其他函数
        public static int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i]++;
                digits[i] = digits[i] % 10;
                if (digits[i] != 0) return digits;
            }
            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;
        }

}
