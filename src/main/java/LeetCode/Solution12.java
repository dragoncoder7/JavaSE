package LeetCode;

import java.util.Arrays;

public class Solution12 {
    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        solution12.removeElement(nums,val);
    }

    public int removeElement1(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }


    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int[] n = new int[length];
        for (int i = 0; i < length; i++) {
            if (nums[i] == val){
                n[i] = i;
            }
        }

        for (int j = 1; j < n.length; j++) {

        }
            
            //Arrays.stream(nums).filter(value -> value == val);
            
        
        return length;
    }
}
