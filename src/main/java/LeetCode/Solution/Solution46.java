package LeetCode.Solution;
public class Solution46 {
    public static void main(String[] args) {
        /* 这里输入您的代码 */
        int[] hours =  new int[]{12,12,30,24,24};
        System.out.println(countCompleteDayPairs(hours));
    }

    public static long countCompleteDayPairs(int[] hours) {
        long res = 0;

        int[] counts = new int[24];

        for (int hour : hours) {
            int temp = hour % 24;// 下标 0 - 23 对应值为下标的数量
            counts[temp]++;
        }

        for (int j = 1; j < hours.length; j++) {
            res += counts[(24 - hours[j] % 24) % 24];  //
        }

        return res;
    }

//    public long countCompleteDayPairs(int[] hours) {
//        long ans = 0;
//        int[] cnt = new int[24];
//        for (int hour : hours) {
//            ans += cnt[(24 - hour % 24) % 24];
//            cnt[hour % 24]++;
//        }
//        return ans;
//    }

}
