package LeetCode.LeetCode75;

import java.util.Arrays;

public class leetcode10 {
    public static void main(String[] args) {
        leetcode10 leetcode10 = new leetcode10();
        leetcode10.moveZeroes(new int[]{0,1,0,3,12});
    }
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}
