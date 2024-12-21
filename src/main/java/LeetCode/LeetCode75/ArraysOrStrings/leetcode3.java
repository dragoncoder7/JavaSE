package LeetCode.LeetCode75.ArraysOrStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode3 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        if (Arrays.stream(candies).max().isPresent()){
            max = Arrays.stream(candies).max().getAsInt();
        }
        System.out.println(max);
        for (int i : candies) {
            if (i + extraCandies >= max) {
                list.add(true);
            }else {
                list.add(false);
            }
        }
        return list;
    }
}
