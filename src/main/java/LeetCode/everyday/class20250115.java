package LeetCode.everyday;

import java.util.Iterator;
import java.util.PriorityQueue;

public class class20250115 {
    public static void main(String[] args) {
        class20250115 class20250115 = new class20250115();
        System.out.println(class20250115.minOperations(new int[]{2,11,10,1,3}, 10));
    }

    /**
     * 3066. 超过阈值的最少操作数 II
     * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
     * 一次操作中，你将执行：
     * 选择 nums 中最小的两个整数 x 和 y 。
     * 将 x 和 y 从 nums 中删除。
     * 将 min(x, y) * 2 + max(x, y) 添加到数组中的任意位置。
     * 注意，只有当 nums 至少包含两个元素时，你才可以执行以上操作。
     * 你需要使数组中的所有元素都大于或等于 k ，请你返回需要的 最少 操作次数。
     *
     * @param nums 参数1
     * @param k 参数2
     * @return 结果
     */
    public int minOperations(int[] nums, int k) {
        int count = 0;
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (long num : nums) {
            queue.add(num);
        }
        while (queue.peek() < k) {
            long x = queue.poll(), y = queue.poll();
            queue.add(x + x + y);
            count++;
        }
        return count;
    }
}
