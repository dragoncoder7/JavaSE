package LeetCode.weeklyContest.fourtwonine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class two {
    public static void main(String[] args) {
        two two = new two();
        //System.out.println(two.maxDistinctElements(new int[]{9,9,10,9,10,10,9,10},3));
        System.out.println(two.countSubarrays(new int[]{-1,-4,-1,4}));
    }
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums); // 对数组排序
        Set<Integer> used = new HashSet<>(); // 用于记录调整后的值

        for (int num : nums) {
            //优先考虑最小 或者最大
            if (!used.contains(num - k)) {
                used.add(num - k);
                continue; // 一旦找到合法值，立即停止当前循环
            }
            //如果set里没有当前的值 就先加进去 一直到遇到重复值
            for (int i = num - k; i <= num + k ; i++) {
                if (!used.contains(i)) {
                    used.add(i);
                    break; // 一旦找到合法值，立即停止当前循环
                }
            }
        }

        return used.size(); // 返回调整后不同元素的最大数量
    }
    public int maxDistinctElements1(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        int max = nums[n - 1];
        int min = nums[0];
        int count = 0;
        for (int i = min - k; i <= max + k && count < n; i++) {
            if (set.contains(i)){
                set.add(i);
            }
            count++;
        }
        if (k == 0){
            for (int num : nums) {
                set.add(num);
            }
            return set.size();
        }
        int[] mins = new int[n];
        int[] maxs = new int[n];
        for (int i = 0; i < n; i++) {
            mins[i] = nums[i] - k;
            maxs[i] = nums[i] + k;
        }
        for (int i = 0; i < n; i++) {
            set.add(mins[i]);
            set.add(maxs[i]);
        }
        return set.size();
    }

    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 1; i <= n - 2; i++){
            if ((float)(nums[i - 1] + nums[i + 1]) == (float) nums[i] / 2){
                res++;
            }
        }
        return res;
    }
}
