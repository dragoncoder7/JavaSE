package LeetCode.Solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution39 {
    public static void main(String[] args) {
        /* 这里输入您的代码 */
        int[][] res = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        System.out.println(Arrays.deepToString(setZeroes(res)));
    }
    //利用set唯一性集合
    public static int[][] setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (rows.contains(i)){
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] != 0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            if (cols.contains(j)){
                for (int i = 0; i < matrix.length; i++) {
                    if (matrix[i][j] != 0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        return matrix;
    }

    //
    public static int[][] setZeroes1(int[][] matrix) {
        int m = matrix.length;//行数
        int n = matrix[0].length;//列数
        boolean[] rowsFlag = new boolean[m];
        boolean[] colsFlag = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    rowsFlag[i] = true;
                    colsFlag[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (rowsFlag[i]){
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            if (colsFlag[j]){
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }
}
