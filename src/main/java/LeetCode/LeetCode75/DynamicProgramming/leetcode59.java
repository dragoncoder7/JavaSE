package LeetCode.LeetCode75.DynamicProgramming;

public class leetcode59 {
    public static void main(String[] args) {
        leetcode59 leetcode59 = new leetcode59();
        System.out.println(leetcode59.tribonacci1(2));
    }

    /**
     * 一维DP
     * @param n
     * @return
     */
    public int tribonacci(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    /**
     * 滚动数组  DP
     * @param n
     * @return
     */
    public int tribonacci1(int n) {
        int p = 0, q = 0, r= 1, s = 1;
        if (n == 0){
            return p;
        }
        if (n < 2){
            return r;
        }
        for (int i = 2; i < n; i++) {
            p = q;
            q = r;
            r = s;
            s = p + q + r;
        }
        return s;
    }
}
