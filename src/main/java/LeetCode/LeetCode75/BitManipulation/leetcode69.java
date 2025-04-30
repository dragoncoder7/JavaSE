package LeetCode.LeetCode75.BitManipulation;

public class leetcode69 {
    public static void main(String[] args) {
        leetcode69 leetcode69 = new leetcode69();
        //System.out.println(leetcode69.minFlips(2,6,5));
        // 7 -> 111
        // 3 -> 011
        // s -> 011
        System.out.println(5&4);

    }

    /**
     * 给你三个正整数 a、b 和 c。
     * 你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算   a OR b == c  成立的最小翻转次数。
     * 「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < 31; ++i) {
            int bit_a = (a >> i) & 1;//得到 x 二进制表示的第 i 位
            int bit_b = (b >> i) & 1;
            int bit_c = (c >> i) & 1;
            if (bit_c == 0) {
                ans += bit_a + bit_b;
            }
            else {
                ans += (bit_a + bit_b == 0 ? 1 : 0) ;
            }
        }
        return ans;
    }
}
