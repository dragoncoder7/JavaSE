package LeetCode.LeetCode75.HeapOrPriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode52 {
    public static void main(String[] args) {
        leetcode52 leetcode52 = new leetcode52();
        System.out.println(leetcode52.totalCost(new int[]{17,12,10,2,7,2,11,20,8},3,4));
    }
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int left = candidates - 1, right = n - candidates;
        if (left + 1 < right) {
            for (int i = 0; i <= left; ++i) {
                pq.offer(new int[]{costs[i], i});
            }
            for (int i = right; i < n; ++i) {
                pq.offer(new int[]{costs[i], i});
            }
        } else {
            for (int i = 0; i < n; ++i) {
                pq.offer(new int[]{costs[i], i});
            }
        }
        long ans = 0;
        for (int i = 0; i < k; ++i) {
            int[] arr = pq.poll();
            int cost = arr[0], id = arr[1];
            ans += cost;
            if (left + 1 < right) {
                if (id <= left) {
                    ++left;
                    pq.offer(new int[]{costs[left], left});
                } else {
                    --right;
                    pq.offer(new int[]{costs[right], right});
                }
            }
        }
        return ans;
    }

    public long totalCost1(int[] costs, int k, int candidates) {
        long sum = 0;
        int n = costs.length;
        int left = candidates, right = n - candidates - 1;
        if (candidates * 2 + k >= n) {
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                sum += costs[i];
            }
            return sum;
        }
        PriorityQueue<Integer> pre = new PriorityQueue<>();
        PriorityQueue<Integer> suf = new PriorityQueue<>();
        for (int i = 0; i < candidates; i++) {
            pre.offer(costs[i]);
            suf.offer(costs[n - 1 - i]);
        }
        for (int i = 0; i < k; i++) {
            if (pre.peek() <= suf.peek()) {
                sum += pre.poll();
                pre.offer(costs[left]);//当前的范围是不包含边界的 所以要先加下标为left的value 再让left++   下面同理
                left++;
            }else {
                sum += suf.poll();
                suf.offer(costs[right]);//
                right--;
            }
        }
//        int preIdx = candidates, sufIdx = n - 1 - candidates;
//        for (int i = 0; i < k; i++) {
//            int preMin = pre.peek(), sufMin = suf.peek();
//            if (preMin <= sufMin) {
//                sum += preMin;
//                pre.poll();
//                pre.offer(costs[preIdx++]);
//            } else {
//                sum += sufMin;
//                suf.poll();
//                suf.offer(costs[sufIdx--]);
//            }
//        }
        return sum;
    }
}
