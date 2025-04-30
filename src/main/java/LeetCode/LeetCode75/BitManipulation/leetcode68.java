package LeetCode.LeetCode75.BitManipulation;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class leetcode68 {
    public static void main(String[] args) {
        leetcode68 leetcode68 = new leetcode68();
        System.out.println(leetcode68.singleNumber(new int[]{4,1,2,1,2}));
    }

    /**
     * leetcode75  68  136.只出现一次的数字
     * 思路 位运算
     * ^ 异或 1 ^ 0 = 1; 1 ^ 1 = 0; 0 ^ 0 = 0;
     * & 与 1&1 = 1 0&0 = 1； 1&0 = 0；
     * a ^ a ^ b = 0 ^ b = b
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int as = 0;
        for (int num : nums) {
            as = as ^ num;
        }
        return as;
    }

    public int singleNumber1(int[] nums) {
        AtomicInteger res = new AtomicInteger();
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i : nums) {
            hashMap.merge(i,1,Integer::sum);
        }
        System.out.println(hashMap);
        hashMap.forEach((k,v) -> {
            if (v == 1){
                res.set(k);
            }
        });
        return res.intValue();
    }
}
