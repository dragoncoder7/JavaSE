package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
public class Solution {
    public static void main(String[] args) {

        //int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals = new int[][]{{1, 4}, {5, 6}};
        */
/*for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }*//*

        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    //自己写的烂代码 思路其实和第二个类似 但没有考虑它是无序的;
    public static int[][] merge(int[][] intervals) {

        if (intervals.length <= 1){
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        int[][] newInter = new int[intervals.length][2];

        for (int i = 0; i < intervals.length; i++) {
            int len = intervals[i].length;
            int[] first = intervals[i];
            boolean tag = false;
            if ( i >= 1 &&  first[1] == intervals[i-1][1]){
                continue;
            }
            for (int j = 0; j < len; j++ ){

                System.out.println(intervals[i][j]);
                if (i < intervals.length - 1){
                    if (first[1] >= intervals[i+1][0]){
                        first[1] =  intervals[i+1][1];
                        newInter[i] = intervals[i];
                        tag = true;
                        break;
                    }else {
                        newInter[i] = intervals[i];
                        break;
                    }
                }
                else {
                    newInter[i] = intervals[i];
                }
            }
            //System.out.println(intervals[i][1]);
        }
        System.out.println(Arrays.deepToString(newInter));
        int n = 0;

        for (int i = 0; i < newInter.length; i++){
            if (newInter[i][0] != 0 && newInter[i][1] != 0){
                n++;
            }
        }
        int[][] answer = new int[n][2];
        int m = 0;
        for (int[] ints : newInter) {
            if (ints[0] != 0 && ints[1] != 0) {
                answer[m] = ints;
                m++;
            }
        }
        return answer;
    }
   }
*/


    public class Solution1 {
        //思路 以第一个为例子 挨个往后面的比 能连的起来 就改值 连不起来 就加进来 PS：前提是得是按顺序的
        public static int[][] merge1(int[][] intervals) {
            if (intervals.length == 0) {
                return new int[0][2];
            }
            //排序
            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
            List<int[]> merged = new ArrayList<>();
            for (int[] interval : intervals) {
                int L = interval[0], R = interval[1];
                if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < L) {
                    merged.add(new int[]{L, R});
                } else {
                    merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
                }
            }
            return merged.toArray(new int[merged.size()][]);
        }

        public static int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

            if (intervals.length <= 1) {
                return intervals;
            }
            //初始化 min 为第一个的i max 为第一个的j
            int min = intervals[0][0];
            int max = intervals[0][1];
            for (int[] interval : intervals) {
                min = Math.min(min, interval[0]);
                max = Math.max(max, interval[1]);
            }
            System.out.println(min);
            System.out.println(max);
            int[] lefts = new int[max + 1];
            int[] rights = new int[max + 1];
            for (int[] interval : intervals) {
                lefts[interval[0]] += 1;
                rights[interval[1]] -= 1;
            }

            int start = -1;
            int end = -1;
            int sum = 0;
            List<int[]> result = new ArrayList<>();
            for (int i = 0; i <= max; i ++) {
                sum += lefts[i] + rights[i];
                if (lefts[i] > 0 && start == -1) {
                    start = i;
                }
                if (rights[i] < 0) {
                    end = i;
                }

                if (sum == 0) {
                    if (start != -1) {
                        int[] cur = new int[2];
                        cur[0] = start;
                        cur[1] = end;
                        result.add(cur);
                    }
                    start = -1;
                    end = -1;
                }
            }
            int[][] finalResult = new int[result.size()][2];
            for (int i = 0; i < result.size(); i ++) {
                int[] cur = result.get(i);
                finalResult[i][0] = cur[0];
                finalResult[i][1] = cur[1];
            }
            return finalResult;
        }

        public static void main(String[] args) {
            int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
            System.out.println(Arrays.deepToString(merge(intervals)));
            System.out.println(Arrays.deepToString(merge1(intervals)));
        }
    }

