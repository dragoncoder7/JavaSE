package LeetCode.LeetCode75.HashTableOrHashCollections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class leetcode23 {
    public static void main(String[] args) {
        leetcode23 leetcode23 = new leetcode23();
        System.out.println(leetcode23.equalPairs(new int[][]{{3,2,1},{1,7,6},{2,7,7}}));
        System.out.println(leetcode23.equalPairs1(new int[][]{{3,2,1},{1,7,6},{2,7,7}}));
        System.out.println(leetcode23.equalPairs2(new int[][]{{3,2,1},{1,7,6},{2,7,7}}));
    }
    public int equalPairs(int[][] grid) {
        int n = grid.length;

        int[][] rows = new int[n][n];
        int[][] columns = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] row = new int[n];
            int[] column = new int[n];
            for (int j = 0; j < n; j++) {
                row[j] = grid[i][j];
                column[j] = grid[j][i];
            }
            rows[i] = row;
            columns[i] = column;
        }

        return countMatchingRows(rows,columns);
    }


    //自己写的
    public int equalPairs1(int[][] grid) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        HashMap<String,Integer> hashMap1 = new HashMap<>();

        int n = grid.length;

        int res = 0;

        for (int i = 0; i < n; i++) {
            int[] row = new int[n];
            int[] column = new int[n];
            for (int j = 0; j < n; j++) {
                row[j] = grid[i][j];
                column[j] = grid[j][i];
            }
            hashMap.merge(Arrays.toString(row),1,Integer::sum);
            hashMap1.merge(Arrays.toString(column),1,Integer::sum);
        }
        for (Map.Entry<String,Integer> entry : hashMap.entrySet()
             ) {
            if (hashMap1.containsKey(entry.getKey())){
                res += entry.getValue() * hashMap1.get(entry.getKey());
            }
        }
        return res;
    }

    //官解
    public int equalPairs2(int[][] grid) {
        int n = grid.length;
        Map<List<Integer>, Integer> cnt = new HashMap<>();

        //List<Integer>, Integer
        //每一行数组 以及 数组数量
        for (int[] row : grid) {
            List<Integer> arr = new ArrayList<>();
            for (int num : row) {
                arr.add(num);
            }
            cnt.put(arr, cnt.getOrDefault(arr, 0) + 1);
        }

        int res = 0;
        //List<Integer>, Integer
        //每一列数组 以及 数组数量
        for (int j = 0; j < n; j++) {
            List<Integer> arr = new ArrayList<>();
            for (int[] ints : grid) {
                arr.add(ints[j]);
            }
            //跟行匹配 相同就+1
            if (cnt.containsKey(arr)) {
                res += cnt.get(arr);
            }
        }
        //返回结果
        return res;
    }
    public int countMatchingRows(int[][] array1, int[][] array2) {
        int count = 0;

        // 遍历 array1 的每一行
        for (int[] row1 : array1) {
            // 遍历 array2 的每一行
            for (int[] row2 : array2) {
                // 如果行内容相同，计数加一
                if (Arrays.equals(row1, row2)) {
                    count++;
                    break; // 如果找到匹配，跳过 array2 的后续行
                }
            }
        }

        return count;
    }
}
