package LeetCode;

import java.util.Arrays;

class Solution7{
    public static void main(String[] args) {
        int[] ints = new int[100];
        for (int i = 0; i < 100; i++) {
            ints[i] = i+1;
        }
        Solution7 s = new Solution7();
        System.out.println(s.searchInsert1(ints, 80));
        System.out.println(Arrays.binarySearch(ints, 88));
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中,返回它将会被按顺序插入的位置
     * @param nums 传入数组
     * @param target 目标值
     * @return 返回值
     */
    public int searchInsert(int[] nums, int target) {
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                index = i;
                return index;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (target < nums[0]){
                return 0;
            }
            if (target > nums[nums.length - 1]){
                return nums.length;
            }
            if (nums[i] < target && nums[i + 1] > target){
                index = i + 1;
            }
        }
        return index;
    }

    public int searchInsert1(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}