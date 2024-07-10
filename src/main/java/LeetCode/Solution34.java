package LeetCode;

import java.util.Arrays;

public class Solution34 {
    public static void main(String[] args) {
        /* 这里输入您的代码 */
        Solution34 s = new Solution34();

        char[][] board = s.tictactoe(new int[][]{{0,0},{2,0},{1,1},{2,1},{2,2}});
        System.out.println(Arrays.deepToString(board));
        System.out.println(s.diagonalSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(4 & 1);
        String ss = "";
        System.out.println(s.myPow(2.0000,-2));
    }
    public char[][] tictactoe(int[][] moves) {
        char[][] board = new char[3][3];
        char c = 'A';
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) {
                board[moves[i][0]][moves[i][1]] = 'A';
            } else {
                board[moves[i][0]][moves[i][1]] = 'B';
            }
        }
        System.out.println(board[0]);
        return board;
    }


    public double myPow(double x, int n) {
        //return Math.pow(x,n);
        double res = 1;
        if (n == 0) return 1;
        for (double i = 0; i < Math.abs(n); i++) {
            res = x * res;
        }
        return n > 0 ? res : 1 / res;
    }
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            if(i == n - i - 1){
                sum += mat[i][i];
            }else {
                sum += mat[i][i];
                sum += mat[i][n - i - 1];
            }
        }
        return sum;
    }
}
