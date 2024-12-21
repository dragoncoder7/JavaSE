package LeetCode.LeetCode75.SlideWindows;

import java.util.ArrayList;
import java.util.List;

public class leetcode17 {
    public static void main(String[] args) {
        leetcode17 leetcode17 = new leetcode17();
        System.out.println(leetcode17.longestSubarray(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
    public int longestSubarray(int[] nums) {
        int res = 0;
        int left = 0, zeroNum = 0;
        for (int right = 0; right < nums.length; right++) {
            zeroNum += 1 - nums[right];
            while (zeroNum > 1){
                zeroNum -= 1 - nums[left++];
            }
            res = Math.max(res, right - left + 1);
        }
        return  res;
    }
    
    public int longestSubarray(int[] nums, int k) {
        int zeroNum = 0;
        List<Integer> list = new ArrayList<>();
        int res = 0;
        for (int i : nums) {
            list.add(i);
            if(i == 0){
                zeroNum++;
            }

            while(zeroNum > 1){
                if(list.get(0) == 0){
                    zeroNum--;
                }
                list.remove(0);
            }
            res = Math.max(res, list.size());
        }
        return res - 1;
    }
}
