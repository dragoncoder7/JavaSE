package LeetCode.LeetCode75.binaryFind;

import java.util.Arrays;

public class leetcode54 {
    public static void main(String[] args) {
        leetcode54 leetcode54 = new leetcode54();
        int[] spells = {5,1,3};
        int[] potions = {1,2,3,4,5};
        long success = 7;
        System.out.println(Arrays.toString(leetcode54.successfulPairs(spells, potions, success)));
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        int n = spells.length, m = potions.length;
        Arrays.sort(potions);
//        for (int i = 0; i < spells.length; i++) {
//            //res[i] = binarySearch(potions, spells[i], success);
//            for (int j = 0; j < potions.length; j++) {
//                int low = j; int high = potions.length - 1;
//                while (low <= high) {
//                    int mid = low + (high - low) / 2;
//                    if (spells[i] * potions[mid] >= success) {
//
//                    }
//                }
//            }
//        }
        for (int i = 0; i < n; i++) {
            long t = (success + spells[i] - 1) / spells[i] - 1;
            res[i] = m - binarySearch(potions, 0, m - 1, t);
        }
        return res;
    }

    public int binarySearch(int[] arr, int lo, int hi, long target) {
        int res = hi + 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > target) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }
}
