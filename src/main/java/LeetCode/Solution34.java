package LeetCode;

import java.util.Arrays;

public class Solution34 {
    public static void main(String[] args) {
        /* 这里输入您的代码 */

        Solution34 s = new Solution34();

        char[][] board = s.tictactoe(new int[][]{{0,0},{2,0},{1,1},{2,1},{2,2}});
        System.out.println(Arrays.deepToString(board));
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
}
