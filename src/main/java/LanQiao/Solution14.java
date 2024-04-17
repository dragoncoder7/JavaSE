package LanQiao;

import java.util.ArrayList;
import java.util.List;

public class Solution14 {

    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        int[] nums = new int[]{1,4,4};
        int target = 4 ;
        System.out.println(solution14.minSubArrayLen1(target, nums));
        List<List<Integer>> list = new ArrayList<>();
    }

    /**
     * 给定一个含有n个正整数的数组和一个正整数 target 。
     * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     * @param target 一个正整数 target
     * @param nums 个含有n个正整数的数组
     * @return 0
     */
    public int minSubArrayLen(int target, int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int n = 0;
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] <= target && sum < target){
                    sum += nums[j];
                    n++;
                }else {
                    break;
                }
                if (sum == target){
                    list.add(n);
                }
            }
        }
        if (list.isEmpty()){
            return 0;
        }
        return list.stream().min(Integer::compareTo).get();
    }

    public int minSubArrayLen1(int target, int[] nums) {
        int l = 0, r = 0;
        int n = nums.length;
        int sum = 0;

        while(r < n && sum < target)
            sum += nums[r++];

        if(r == n)
            if (sum < target)
                return 0;
            else{
                while(sum > target)
                    sum -= nums[l++];
            }

        while(r < n){
            if(sum < target) sum += nums[r++];
            sum -= nums[l++];
        }
        if(sum < target) return r-l+1;
        return r - l;

    }
}
