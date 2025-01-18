package LeetCode.everyday;

import java.util.HashSet;
import java.util.Set;

public class class20250108 {
    public static void main(String[] args) {
        class20250108 class20250108 = new class20250108();
        System.out.println(class20250108.largestGoodInteger("6777133339"));

    }

    /**
     * 给你一个字符串 num ，表示一个大整数。如果一个整数满足下述所有条件，则认为该整数是一个 优质整数 ：
     * 该整数是 num 的一个长度为 3 的 子字符串 。
     * 该整数由唯一一个数字重复 3 次组成。
     * 注意：
     * 子字符串 是字符串中的一个连续字符序列。
     * num 或优质整数中可能存在 前导零 。
     * @param num 字符串 num
     * @return 以字符串形式返回 最大的优质整数 。如果不存在满足要求的整数，则返回一个空字符串 "" 。
     */
    public String largestGoodInteger(String num) {
        int res = -1;
        for(int i = 1; i < num.length() - 1; i++){
            if(num.charAt(i - 1) == num.charAt(i) && num.charAt(i) == num.charAt(i + 1)){
                res = Math.max(res,num.charAt(i) - '0');
            }
        }
        return res >= 0 ? String.valueOf(res).repeat(3) : "";
    }
}
