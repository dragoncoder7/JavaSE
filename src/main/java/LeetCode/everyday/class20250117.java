package LeetCode.everyday;

public class class20250117 {
    public static void main(String[] args) {
        class20250117 class20250117 = new class20250117();
        System.out.println(class20250117.minimumSubarrayLength(new int[]{1,2,3}, 2));
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
     * 1 <= nums.length <= 2 * 10^5
     * 0 <= nums[i] <= 10^9
     * 0 <= k <= 10^9
     */
    public int minimumSubarrayLength(int[] nums, int k) {
        int sum = 0,right = 0;
        int max = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum = nums[right];
            if(nums[right] >= k) {
                return 1;
            }//固定滑动窗口右边 从长度1往左边扩
            for (int left = right - 1; left >= 0 && (sum | nums[left]) != nums[left] ; left--) {
                nums[left] |= sum;
                if(nums[left] >= k) {
                    max = Math.min(max, right - left + 1);
                }
            }
            right++;
        }
        if(max == Integer.MAX_VALUE) {
            return -1;
        }
        return max;
    }
    public int minimumSubarrayLength2(int[] nums, int k) {
        int n = nums.length;
        int[] bits = new int[30];
        int res = Integer.MAX_VALUE;
        for (int left = 0, right = 0; right < n; right++) {
            for (int i = 0; i < 30; i++) {
                bits[i] += (nums[right] >> i) & 1;
            }
            while (left <= right && calc(bits) >= k) {
                res = Math.min(res, right - left + 1);
                for (int i = 0; i < 30; i++) {
                    bits[i] -= (nums[left] >> i) & 1;
                }
                left++;
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int calc(int[] bits) {
        int ans = 0;
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] > 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }


    public int minimumSubarrayLength1(int[] nums, int k) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int value = 0;
            int left = 0;
            int right = i + 1;//下标
            int count = 0;
            while (count < right){
                value |= nums[count];
                count++;
            }
            if (value >= k){
                return right - left;
            }
            while (right < n){
                value |= nums[right];
                value &= nums[left];
                if (value >= k){
                    return right - left + 1;
                }
                left++;
                right++;
            }
        }
        return -1;
    }
}
