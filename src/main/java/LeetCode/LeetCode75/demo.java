package LeetCode.LeetCode75;

import com.sun.source.tree.BinaryTree;
import io.swagger.models.auth.In;

import java.util.*;

public class demo {
    public static void main(String[] args) {
        demo demo = new demo();
        System.out.println(Arrays.toString(demo.dailyTemperatures1(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    class Trie {

        /** Initialize your data structure here. */
        List<String> list;
        BinaryTree binaryTree;
        public Trie() {
            list = new ArrayList<>();
        }

        public void insert(String word) {
            list.add(word);
        }

//        public boolean search(String word) {
//
//        }
//
//        public boolean startsWith(String prefix) {
//
//        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        int n = temperatures.length;
        int[] next = new int[101];
        Arrays.fill(next,Integer.MAX_VALUE);
        for (int i = n - 1; i >= 0 ; i--) {
            int temp = temperatures[i];
            int higher = Integer.MAX_VALUE;
            for (int j = temp + 1; j <= 100; j++) {
                if (next[j] < higher) {
                    higher = next[j];
                }
            }
            if (higher < Integer.MAX_VALUE) {
                ans[i] = higher - i;
            }
            next[temp] = i;
        }
        return ans;
    }
    //73,74,75,71,69,72,76,73
    //0 +1 +2 -2 -4 -1 +3 0
    public int[] dailyTemperatures1(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> queue = new Stack<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int temperature = temperatures[i];
            while (!queue.isEmpty() && temperatures[queue.peek()] < temperature){
                int index = queue.pop();
                ans[index] = i - index;
            }
            queue.push(i);
        }
        return ans;
    }
}
