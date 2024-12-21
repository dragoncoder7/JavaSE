package LeetCode.LeetCode75.SlideWindows;

import java.util.ArrayList;
import java.util.List;

public class leetcode16 {
    public static void main(String[] args) {
        leetcode16 leetcode16 = new leetcode16();
        System.out.println(leetcode16.longestOnes2(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }

    public int longestOnes2(int[] nums, int k) {
        int zeroNum = 0;
        List<Integer> list = new ArrayList<>();
        int res = 0;
        for (int i : nums) {
            list.add(i);
            if(i == 0){
                zeroNum++;
            }

            while(zeroNum > k){
                if(list.get(0) == 0){
                    zeroNum--;
                }
                list.remove(0);
            }
            res = Math.max(res, list.size());
        }
        return res;
    }
    public int longestOnes1(int[] nums, int k) {
        int ans = 0;
        int cnt0 = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            cnt0 += 1 - nums[right]; // 0 变成 1，用来统计 cnt0
            while (cnt0 > k) {
                cnt0 -= 1 - nums[left++];
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int[] P = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            P[i] = P[i - 1] + (1 - nums[i - 1]);
        }

        int ans = 0;
        for (int right = 0; right < n; ++right) {
            int left = binarySearch(P, P[right + 1] - k);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int binarySearch(int[] P, int target) {
        int low = 0, high = P.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (P[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
