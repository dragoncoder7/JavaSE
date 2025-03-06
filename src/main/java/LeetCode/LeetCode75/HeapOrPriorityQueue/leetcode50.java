package LeetCode.LeetCode75.HeapOrPriorityQueue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class leetcode50 {
    public static void main(String[] args) {
        leetcode50 leetcode50 = new leetcode50();
        System.out.println(Integer.MAX_VALUE);
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        System.out.println(1);
    }
    static class SmallestInfiniteSet {
        private final Queue<Integer> queue;
        public SmallestInfiniteSet() {
            this.queue = new PriorityQueue<>();
            for (int i = 1; i <= 1000; i++) {
                this.queue.add(i);
            }
        }

        public int popSmallest() {
            int value = queue.poll();
            return value;
        }

        public void addBack(int num) {
            if (!queue.contains(num)){
                queue.add(num);
            }
        }
    }
    class SmallestInfiniteSet1 {
        boolean[] vis = new boolean[1010] ;
        PriorityQueue<Integer> q = new PriorityQueue<>((a , b) -> a - b) ;
        int idx = 1 ;

        public int popSmallest() {
            int ans;
            if(!q.isEmpty()) {
                ans = q.poll() ;
                vis[ans] = false ;
            }
            else {
                ans = idx++ ;
            }
            return ans ;
        }

        public void addBack(int x) {
            if(x >= idx || vis[x]) {
                return ;
            }
            if(x == idx - 1) {
                idx-- ;
            }
            else {
                q.add(x) ;
                vis[x] = true ;
            }
        }
    }

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
}
