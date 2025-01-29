package LeetCode.everyday;

public class class20250114 {
    public static void main(String[] args) {
        class20250114 class20250114 = new class20250114();
        System.out.println();
    }

    /**
     * 3065. 超过阈值的最少操作数 I
     * @param nums
     * @param k
     * @return
     */
    public int minOperations(int[] nums, int k) {
        int count = 0;
        for(int i : nums){
            if(i < k){
                count++;
            }
        }
        return count;
    }
}
