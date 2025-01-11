package LeetCode.LeetCode75.Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class leetcode27 {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(1000));
        System.out.println(recentCounter.ping(3000));
        System.out.println(recentCounter.ping(4000));
        System.out.println(recentCounter.ping(5000));
    }
    static class RecentCounter {
        Queue<Integer> queue;

        public RecentCounter() {
            queue = new ArrayDeque<>();
        }
        //[1], [100], [3001], [3002]
        public int ping(int t) {
            queue.offer(t);
            while (queue.peek() < t - 3000) {
                queue.poll();
            }
            return queue.size();
        }
    }
}
