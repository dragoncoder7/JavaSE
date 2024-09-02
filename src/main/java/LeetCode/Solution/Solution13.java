package LeetCode.Solution;

import java.util.Arrays;

public class Solution13 {
    public static void main(String[] args) {
        Solution13  s = new Solution13();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(s.twoSum(nums, target)));
        System.out.println(Arrays.toString(s.twoSum1(nums, target)));
    }

    /**
     * 167. 两数之和 II - 输入有序数组
     * 给你一个下标从 1 开始的整数数组numbers ，该数组已按 非递减顺序排列 ，请你从数组中找出满足相加之和等于目标数target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
     * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
     * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
     * 你所设计的解决方案必须只使用常量级的额外空间。
     * @param numbers 整数数组numbers
     * @param target 目标数target
     * @return 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        for (int i = 0, j = numbers.length - 1; i < j; i++){
            int first = numbers[i];
            for (int k = i + 1; k <= j; k++){
                int second = numbers[k];
                if (first + second == target){
                    ans[0] = i + 1;
                    ans[1] = k + 1;
                    return ans;
                }
            }
        }
        return ans;
    }

    //题解答案
    public int[] twoSum1(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0) return new int[0];

        int len = numbers.length;
        int lo = 0, hi = len - 1;
        while(lo < hi){
            int sum = numbers[lo] + numbers[hi];
            int loVal = numbers[lo], hiVal = numbers[hi];
            if(sum < target){
                while(lo < hi && numbers[lo] == loVal) lo ++;
            } else if(sum > target){
                while(lo < hi && numbers[hi] == hiVal) hi --;
            } else{
                return new int[]{lo + 1, hi + 1};
            }
        }

        return new int[0];
    }
}
