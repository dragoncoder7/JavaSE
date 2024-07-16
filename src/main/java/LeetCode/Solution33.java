package LeetCode;

import java.util.*;

public class Solution33 {
    public static void main(String[] args) {
        /* 这里输入您的代码 */
        String target = "0202";
        String init = "0000";
        Solution33 solution33 = new Solution33();
        System.out.println(solution33.openLock1(new String[]{"0201","0101","0102","1212","2002"}, target));
    }
    public int dfs(int init, int target, int[] deadens){
        int right = 1, t = 10;
        for (int i : deadens) {
            if (i == init){
                return  -1;
            }
        }
        if (init != target){
            //left += dfs((init + 9) % 10, target, deadens);
            right += dfs((init + 1) % 10, target, deadens);
        }else {
            return 0;
        }
        /*if (init.charAt(i) != target.charAt(i)){
            init.charAt(i)++;
            return 1;
        }*/
        return right;
    }
    public int openLock1(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }

        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) {
            return -1;
        }

        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> seen = new HashSet<>();
        seen.add("0000");

        while (!queue.isEmpty()) {
            ++step;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                if (queue.isEmpty()){
                    return -1;
                }
                String status = queue.poll();
                for (String nextStatus : get(status)) {
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

    public char numPrev(char x) {
        return x == '0' ? '9' : (char) (x - 1);
    }

    public char numSucc(char x) {
        return x == '9' ? '0' : (char) (x + 1);
    }

    // 枚举 status 通过一次旋转得到的数字
    public List<String> get(String status) {
        List<String> ret = new ArrayList<String>();
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
}
