package LeetCode.LeetCode75;

import java.util.Arrays;

public class leetcode14 {
    public static void main(String[] args) {
        leetcode14 leetcode14 = new leetcode14();
        System.out.println(leetcode14.findMaxAverage(new int[]{0,4,0,3,2},1));
    }
    public double findMaxAverage(int[] nums, int k) {
//        if (k == 1){
//            return Arrays.stream(nums).max().getAsInt();
//        }
        int n = nums.length;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double maxSum = sum;
        //n-k+1 = 5-2+1 6 i < 6
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum / k;
    }

//    public double findMaxAverage(int[] nums, int k) {
//        int sum = 0;
//        int n = nums.length;
//        for (int i = 0; i < k; i++) {
//            sum += nums[i];
//        }
//        int maxSum = sum;
//        for (int i = k; i < n; i++) {
//            sum = sum - nums[i - k] + nums[i];
//            maxSum = Math.max(maxSum, sum);
//        }
//        return 1.0 * maxSum / k;
//    }
}
