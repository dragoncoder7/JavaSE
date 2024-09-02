package LeetCode.Solution;

import java.util.Arrays;

public class Solution21 {
    public static void main(String[] args) {
        /* 这里输入您的代码 */
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int res = removeDuplicates(nums);
        System.out.println(res);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * Example 1:
     *
     * Input: nums = [1,1,2]
     * Output: 2, nums = [1,2,_]
     * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     * Example 2:
     *
     * Input: nums = [0,0,1,1,1,2,2,3,3,4]
     * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
     * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     * ?
     *
     * Constraints:
     *
     * 1 <= nums.length <= 3 * 104
     * -100 <= nums[i] <= 100
     * nums is sorted in non-decreasing order.
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int left = 0, right = 0;

        while(right < nums.length){
            if(nums[left] < nums[right]){
                left++;
                nums[left] = nums[right];
            }else {
                right++;
            }
        }
        return left+1;
    }
}
