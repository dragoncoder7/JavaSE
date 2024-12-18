package LeetCode.LeetCode75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

public class leetcode13 {
    public static void main(String[] args) {
        leetcode13 leetcode13 = new leetcode13();
        int[] nums = new int[]{2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};
        System.out.println(leetcode13.maxOperations(nums,3));
    }

    /**
     * 利用hash key 代表值，val 代表出现的次数
     * 遍历数组 因为要取两个数 所以找有没有跟它互补加起来为k的数就行了 val大于0 说明有 结果++ 没有就存进去这个数
     * @param nums
     * @param k
     * @return
     */
    public int maxOperations(int[] nums, int k) {
        int res = 0;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            int c = cnt.getOrDefault(k - x, 0);
            if (c > 0) {
                cnt.put(k - x, c - 1);
                res++;
            } else {
                cnt.merge(x, 1, Integer::sum);
            }
        }
        return res;
    }
}
