package LeetCode.LeetCode75.HeapOrPriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class leetcode51 {
    public static void main(String[] args) {
        leetcode51 leetcode51 = new leetcode51();
        System.out.println();
    }

    /**
     * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，两者长度都是 n ，再给你一个正整数 k 。你必须从 nums1 中选一个长度为 k 的 子序列 对应的下标。
     * 对于选择的下标 i0 ，i1 ，...， ik - 1 ，你的 分数 定义如下：
     * nums1 中下标对应元素求和，乘以 nums2 中下标对应元素的 最小值 。
     * 用公式表示： (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]) 。
     * 请你返回 最大 可能的分数。
     * 一个数组的 子序列 下标是集合 {0, 1, ..., n-1} 中删除若干元素得到的剩余集合，也可以不删除任何元素。
     * 输入：nums1 = [1,3,3,2], nums2 = [2,1,3,4], k = 3
     * 输出：12
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int length = nums1.length;

        Integer[] index = new Integer[length];

        for (int i = 0; i < length; i++) {
            index[i] = i;
        }

        //算法 sum nums1(1、2、3) * min nums2(1、2、3);给nums2排序 选择尽可能大的value
        Arrays.sort(index, (i, j) -> nums2[j] - nums2[i]);

        //存放nums1中尽可能大的元素
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums1[index[i]];
            pq.offer(nums1[index[i]]);
        }
        // 初始化最大值
        long max = sum * nums2[index[k - 1]];

        // 遍历后续nums1中的元素，防止有可能产生更大的ans
        // 为什么是从k往后 因为这里已经给nums2的id排序了 当前遍历到的一定是选中在nums2中最小的值
        for (int i = k; i < length; i++) {
            int x = nums1[index[i]];
            //在大于k的后续元素中替换掉前面最小的元素值 再乘以最小的nums2值
            if (x > pq.peek()) {
                sum += x - pq.poll();
                pq.offer(x);
            }
            max = Math.max(max, sum * nums2[index[i]]);
        }

        return max;
    }
}
