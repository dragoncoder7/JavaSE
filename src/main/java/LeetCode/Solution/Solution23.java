package LeetCode.Solution;
public class Solution23 {
    public static void main(String[] args) {
        /* 这里输入您的代码 */
        int[] nums = {9,72,34,29,-49,-22,-77,-17,-66,-75,-44,-30,-24};
        Solution23 s = new Solution23();
        System.out.println(s.arraySign(nums));
    }
    public int arraySign(int[] nums) {
        int count = 0;
        for(int num : nums){
            if (num == 0){
                return 0;
            }
            if(num < 0){
                count++;
            }
        }
        return count % 2 == 0 ? 1 : -1;
    }
}
