package LeetCode.LeetCode75.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode58 {
    public static void main(String[] args) {
        leetcode58 leetcode58 = new leetcode58();
        System.out.println(leetcode58.combinationSum3(3,7));
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (minValue(k) > n || maxValue(k) < n){
            return null;
        }
        //a != b != c
        //a + b + c = n
        //a < n; b < n; c < n
        return null;
    }

    public int minValue(int n) {
        int value = 0;
        for (int i = 1; n > 0; n--,i++) {
            value += i;
        }
        return value;
    }

    public int maxValue(int n) {
        int value = 0;
        for (int i = 9; n > 0; n--,i--) {
            value += i;
        }
        return value;
    }
}
