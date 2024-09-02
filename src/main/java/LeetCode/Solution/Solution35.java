package LeetCode.Solution;

import java.math.BigDecimal;

public class Solution35 {
    public static void main(String[] args) {
        /* 这里输入您的代码 */
        Solution35 s = new Solution35();
        System.out.println(s.multiply("987654321","123456789"));

    }

    public String multiply(String num1, String num2) {
        double val = Double.parseDouble(num1) * Double.parseDouble(num2);
        BigDecimal bigDecimal = new BigDecimal(val);
        return bigDecimal.toString();
    }
}
