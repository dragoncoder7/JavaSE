package LeetCode.LeetCode75.PrefixSum;

public class leetcode18 {
    public static void main(String[] args) {
        leetcode18 leetcode18 = new leetcode18();
        System.out.println(leetcode18.largestAltitude(new int[]{-5,1,5,0,-7}));
    }
    public int largestAltitude(int[] gain) {
        int res = 0;
        int ans = 0;
        for (int i : gain) {
            res += i;
            ans = Math.max(ans,res);
        }
        return ans;
    }
}
