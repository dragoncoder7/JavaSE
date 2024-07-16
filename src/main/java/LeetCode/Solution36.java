package LeetCode;

import oracle.sql.CHAR;

import java.util.*;

public class Solution36 {
    public static void main(String[] args) {
        /* 这里输入您的代码 */
        Solution36 solution36 = new Solution36();
        int i = solution36.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202");
        System.out.println(solution36.numSquares(188));
        System.out.println(Math.sqrt(16));
    }

    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }

    /**
     *  * 给你一个死锁字符串数组，和一个目标字符串，返回从初始字符串到目标字符串的最小步数，如果无法到达，返回-1
     *  思路 先判断初始字符串是否已经死锁; 若已经死锁 直接结束；
     *  开始bfs 若死锁 -1 若没有死锁
     *  字符串里的每个字符挨个判断是否与目标一致
     *  从不一致的 如果匹配到死锁字符串 返回-1
     *
     * @param deadends 死锁字符串
     * @param target 目标字符串
     * @return 最小达到目标次数
     */
    public int openLock(String[] deadends, String target) {
        String init = "0000";
        if (init.equals(target)) {
            return 0;
        }

        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains(init)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(init);
        Set<String> seen = new HashSet<>();
        seen.add(init);
        /*if (init in deadends){
            return  -1;
        }*/
        int step = 0;
        while (!queue.isEmpty()){
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (String nextStatus : get(cur)) {
                    if (!seen.contains(nextStatus) && !dead.contains(nextStatus)) {
                        if (nextStatus.equals(target)) {
                            return step;
                        }
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }

        return -1;
    }
    public List<String> get(String status) {
        List<String> ret = new ArrayList<>();
        char[] array = status.toCharArray();
        for (int i = 0; i < 4; ++i) {
            char num = array[i];
            array[i] = numPrev(num);
            ret.add(new String(array));
            array[i] = numSucc(num);
            ret.add(new String(array));
            array[i] = num;
        }
        return ret;
    }
    public char numPrev(char x) {
        return x == '0' ? '9' : (char) (x - 1);
    }

    public char numSucc(char x) {
        return x == '9' ? '0' : (char) (x + 1);
    }
}
