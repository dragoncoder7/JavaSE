package LeetCode.Solution;

import java.util.Arrays;

public class Solution3 {
    /*
    旋转矩阵
    给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
    不占用额外内存空间能否做到？
        给定 matrix =
    [
      [1,2,3],
      [4,5,6],
      [7,8,9]
    ],

    原地旋转输入矩阵，使其变为:
    [
      [7,4,1],
      [8,5,2],
      [9,6,3]
    ]
    */

    /**
     *
     *通过一个临时数组来完成
     * @param matrix 二维数组
     */
    public  void rotate(int[][] matrix) {
        int[][] rotatedMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                /*
                顺时针旋转90度
                rotatedMatrix[j][matrix[i].length - i - 1] = matrix[i][j];
                */
                //逆时针旋转90度
                rotatedMatrix[matrix[i].length - j - 1][i] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++){
            System.arraycopy(rotatedMatrix[i], 0, matrix[i], 0, matrix[i].length);
        }
    }

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Solution3 solution3 =  new Solution3();
        solution3.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}

