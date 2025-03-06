package DataStructureAndAlgorithm.DynamicProgramming;

public class DP {
    public static void main(String[] args) {
        DP DP = new DP();
        System.out.println(DP.climbStairs(18));
    }
    public int climbStairs(int n) {
        if (n == 1 || n == 0){
            return 1;
        }
        return dp(n);
    }

    public static int dp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
