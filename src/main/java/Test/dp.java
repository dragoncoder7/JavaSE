package Test;

import java.util.Date;

public class dp {
    private static int count = 0;
    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        System.out.println(new Date());
        dp dp = new dp();
        try {
            System.out.println(dp.dpfloor(48));
        }catch (StackOverflowError e){
            System.out.println("最大栈深度为"+ count);
        }
        System.out.println((System.currentTimeMillis() - now) / 1000);
    }
    public int dpfloor(int floor){
        count++;
        if (floor == 1){
            return 1;
        }
        if (floor == 2){
            return 2;
        }
        return dpfloor(floor - 1) + dpfloor(floor - 2);
    }

    public int climbStairs(int n) {
        if (n <= 1) return 1;
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
