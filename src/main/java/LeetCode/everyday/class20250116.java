package LeetCode.everyday;

public class class20250116 {
    public static void main(String[] args) {
        class20250116 class20250116 = new class20250116();
        System.out.println(class20250116.minimumSubarrayLength(new int[]{2,1,8}, 10));
    }

    /**
     * 给你一个 非负 整数数组 nums 和一个整数 k 。
     * 如果一个数组中所有元素的按位或运算 OR 的值 至少 为 k ，那么我们称这个数组是 特别的 。
     * 请你返回 nums 中 最短特别非空
     * 子数组
     * 的长度，如果特别子数组不存在，那么返回 -1 。
     *
     * @param nums 參數
     * @param k 參數
     * @return 结果
     *
     * 1 <= nums.length <= 50
     * 0 <= nums[i] <= 50
     * 0 <= k < 64
     */
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int value = 0;
            for (int j = i; j < n; j++) {
                value |= nums[j];
                if (value >= k){
                    res = Math.min(res, value);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
