package LeetCode;

public class Solution6 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,7,3,6,5,6};
        Solution6 s = new Solution6();
        System.out.println(s.pivotIndex(nums));
    }

    /**
     *  给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
     *  找关系！！！！！！！！！！！！
     *  sum = sumLeft[0~i] +num[i] + sumRight[i~n-1]
     * @param nums 传入的int数组
     * @return 返回值 -1 表示不存在中心索引 否则返回中心索引下标
     */
    public int pivotIndex(int[] nums) {
        int sum = 0,index = -1,sumLeft = 0;

        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++){
            sumLeft += nums[i];
            if (sum-sumLeft + nums[i] == sumLeft){
                index = i;
                break;
            }
        }
        return index;
    }
}


