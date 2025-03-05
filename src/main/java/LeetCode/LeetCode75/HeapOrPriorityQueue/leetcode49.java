package LeetCode.LeetCode75.HeapOrPriorityQueue;

import java.util.Arrays;

public class leetcode49 {
    public static void main(String[] args) {
        leetcode49 leetcode49 = new leetcode49();
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(leetcode49.findKthLargest(nums, 2));
    }
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
