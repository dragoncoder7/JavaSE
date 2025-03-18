package LeetCode.LeetCode75.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode58 {
    public static void main(String[] args) {
        leetcode58 leetcode58 = new leetcode58();
        System.out.println();
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < k; i++) {
            res += i;
        }
        if (res > n) return list;
        //int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= 9; i++) {
            set.add(i);
        }
        return list;
    }

    public void backTrack(List<List<Integer>> list, int k, int n, int sum){
        List<Integer> sumList = new ArrayList<>();
        if (sum == n) {
            list.add(sumList);
        }else {
            if (sum < n) {
                for (int i = 0; i < k; i++) {

                }
            }
        }
    }
}
