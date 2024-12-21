package LeetCode.LeetCode75.PrefixSum;

public class leetcode19 {
    public static void main(String[] args) {
        leetcode19 leetcode19 = new leetcode19();
        System.out.println(leetcode19.pivotIndex(new int[]{2, 1, -1}));
    }
    public int pivotIndex(int[] nums) {
        //傻逼行为 双重循环 不建议 两个单次循环就能解决 见pivotIndex1
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }
            for (int j = right; j > i ; j--) {
                rightSum += nums[j];
            }
            if (leftSum == rightSum){
                return i;
            }
        }
        return -1;
    }
    public int pivotIndex1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int left = 0;
        for(int i = 0; i < nums.length; i++){
            sum -= nums[i];
            if(left == sum){
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
}
