package LeetCode.LeetCode75.BitManipulation;

import java.util.Arrays;

public class leetcode67 {
    public static void main(String[] args) {
        leetcode67 leetcode67 = new leetcode67();
        int[] ints = leetcode67.countBits(2);
        System.out.println(Arrays.toString(ints));
        System.out.println(Integer.bitCount(2));

    }
    public int[] countBits1(int n) {
        int[] ans = new int[n + 1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= 9; j++){
                if(((1 << j) & i) != 0){
                    ans[i]++;
                }
            }
        }
        return ans;
    }
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }
    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1); // x=x & (x−1)；将 x 的二进制表示的最后一个 1 变成 0 循环是把所有的包含了1的全都变为- 那结果就是0 所以条件就是 x > 0
            ones++;
        }
        return ones;
    }
}
