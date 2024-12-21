package LeetCode.LeetCode75.ArraysOrStrings;

public class leetcode8 {
    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{9,10,5,11,10,9,8}));
    }
    public static boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3){
            return false;
        }
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];

        leftMin[0] = nums[0];
        rightMax[rightMax.length - 1]=nums[n - 1];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
//            int min = Integer.MAX_VALUE;
//            for (int j = 0; j < i; j++) {
//                min = Math.min(nums[j],min);
//            }
//            leftMin[i] = Math.min(nums[i],min);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
//            int max = Integer.MIN_VALUE;
//            for (int j = i; j < n; j++) {
//                max = Math.max(nums[j],max);
//            }
//            rightMax[i] = Math.max(nums[i],max);
        }
        for (int i = 1; i < n - 1; i++) {
            if (leftMin[i - 1] < nums[i] && nums[i] < rightMax[i + 1]){
                return true;
            }
        }
        return false;
    }
    public boolean increasingTriplet1(int[] nums) {
        // input: array of numbers, not empty;
        // output: true or false;

        // steps:
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;

        for (int big: nums) {
            if (big <= min) {
                min = big;
            } else if (big <= mid) {
                mid = big;
            } else {
                return true;
            }
        }

        return false;
    }
}
