package LanQiao;

import java.util.Arrays;

public class Solution16{
    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        int[] nums = {0,1,0,3,12};
        solution16.moveZeroes(nums);

        //System.out.println(Arrays.toString(nums));
        for (int i = 1; i <= 100; i++) {
            System.out.println("第"+i+"个理由：断腕神器"+i);
        }
    }
    public void moveZeroes(int[] nums) {
        int N = nums.length;
        int[] ans = new int[N];
        int m = 0;
        for(int i = 0; i < N; i++){
            if(nums[i] != 0){
                ans[m] = nums[i];
                m++;
            }
        }
        System.out.println(Arrays.toString(ans));
        nums = ans;
    }
}
