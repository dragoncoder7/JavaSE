package LeetCode.LeetCode75.HashTableOrHashCollections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class leetcode20 {
    public static void main(String[] args) {
        leetcode20 leetcode20 = new leetcode20();

        System.out.println(leetcode20.findDifference(new int[]{1,2,3},new int[]{2,4,6}));
    }
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i : nums1) {
            hashSet1.add(i);
        }
        for (int i : nums2) {
            hashSet2.add(i);
        }
        for (int i : hashSet1) {
            if (!hashSet2.contains(i)){
                list1.add(i);
            }
        }
        for (int i : hashSet2) {
            if (!hashSet1.contains(i)){
                list2.add(i);
            }
        }
        ans.add(list1);
        ans.add(list2);
        return ans;
    }
}
