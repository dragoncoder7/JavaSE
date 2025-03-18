package LeetCode.LeetCode75.DynamicProgramming;

public class leetcode60 {
    public static void main(String[] args) {
        leetcode60 leetcode60 = new leetcode60();
        System.out.println(leetcode60.minCostClimbingStairs(new int[]{10,15,20}));
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

    /**
     * 滚动数组 优化
     * @param cost
     * @return
     */
    public int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        int prev = 0, curr = 0;
        for (int i = 2; i <= n; i++) {
            int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
