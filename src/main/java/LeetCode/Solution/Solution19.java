package LeetCode.Solution;


import java.util.Arrays;

public class Solution19 {

    public static void main(String[] args) {
        Solution19  s = new Solution19();
        int[] nums = {0,1,0,3,12};
        s.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

        public void moveZeroes(int[] nums) {
            //两个指针 一个用来记录0 一个用来记录非0
            int left = 0 ,right = 0;
            while (right < nums.length){
                if(nums[right] != 0){
                    swap(nums,left,right);
                    left++;
                }
                right++;
            }
            System.out.println(Arrays.toString(nums));
        }
        public void swap(int[] nums,int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

}
