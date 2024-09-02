package LeetCode.Solution;
public class Solution37 {
    public static void main(String[] args) {
        /* 这里输入您的代码 */ 
    }
    public String tictactoe(int[][] moves) {
        int length = 9;
        int stepSum = 0;
        int stepA = 0;
        int stepB = 0;
        for (int i = 0; i < moves.length; i++) {
            stepSum++;
            if (i % 2 == 0){
                stepA++;
                if (judgeAisWin(stepA,moves,stepSum)){
                    return "A";
                }
            }else {
                stepB++;
                if (judgeBisWin(stepB,moves,stepSum)){
                    return "B";
                }
            }
        }
        if (stepSum + 1 == length){
            return "Draw";
        }else {
            return "Pending";
        }
    }
    public boolean judgeAisWin(int step ,int[][] moves,int stepSum){
        if (step < 3){
            return false;
        }
        /**
         * 判断A是否赢了的逻辑
         */
        return true;
    }

    public boolean judgeBisWin(int step , int[][] moves, int stepSum){
        if (step < 3){
            return false;
        }
        /**
         * 判断B是否赢了的逻辑
         */
        return true;
    }


}
