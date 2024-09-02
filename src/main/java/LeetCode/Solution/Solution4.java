package LeetCode.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution4 {
    /*零矩阵
    编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零*/
    public void setZeroes(int[][] matrix) {
        int M = matrix.length;//矩阵行数
        int N = matrix[0].length;//矩阵列数

        List<Integer> listRow = new ArrayList<>();
        List<Integer> listCol = new ArrayList<>();
        //考虑特殊情况 如果有一列一行 或者 一条对角线为全0 则整个矩阵直接置全0

        //获得值为0的行列下标，存入listRow listCol
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    if (!listRow.contains(i)) {
                        listRow.add(i);
                    }
                    if (!listCol.contains(j)) {
                        listCol.add(j);
                    }
                }
            }
        }
        //System.out.println(listRow + listCol);
        //根据listRow listCol 把对应行 对应列 置0
        for (Integer integer : listRow) {
            Arrays.fill(matrix[integer], 0);
        }
        for (Integer integer : listCol){
            for(int i = 0; i < M; i++){
                matrix[i][integer] = 0;
            }
        }
    }

    //方法二 额外使用两个数组
    //时间复杂度 O(MN)
    //空间复杂度 O(MN)
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        System.out.println(Arrays.toString(row));
        System.out.println(Arrays.toString(col));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                          {0,1,2,0},
                          {3,4,5,2},
                          {1,3,1,5}
                                    };
        Solution4 solution4 = new Solution4();
        solution4.setZeroes(matrix);
        solution4.setZeroes1(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
