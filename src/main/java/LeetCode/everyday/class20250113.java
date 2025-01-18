package LeetCode.everyday;

public class class20250113 {
    public static void main(String[] args) {
        class20250113 class20250113 = new class20250113();
        System.out.println(class20250113.waysToSplitArray(new int[]{}));
    }

    /**
     * 2270. 分割数组的方案数
     * 给你一个下标从 0 开始长度为 n 的整数数组 nums 。
     * 如果以下描述为真，那么 nums 在下标 i 处有一个 合法的分割 ：
     * 前 i + 1 个元素的和 大于等于 剩下的 n - i - 1 个元素的和。
     * 下标 i 的右边 至少有一个 元素，也就是说下标 i 满足 0 <= i < n - 1 。
     * 请你返回 nums 中的 合法分割 方案数
     * <p>
     * 考虑极端情况下 全为最大或者最小 使用int会超长度
     * 2 <= nums.length <= 10^5
     * -10^5 <= nums[i] <= 10^5
     * @param nums 参数
     * @return 结果
     */
    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int count = 0;
        long left = 0, right = sum;
        for (int i = 0; i < nums.length - 1; i++) {
            left += nums[i];
            right -= nums[i];
            if (left >= right){
                count++;
            }
        }
        return count;
    }
}
