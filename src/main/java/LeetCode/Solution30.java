package LeetCode;

import java.util.Arrays;

public class Solution30 {
    public static void main(String[] args) {
        /* 这里输入您的代码 */
        String result = "";
        result = String.valueOf(1);
        System.out.println(result);
        Solution30 s = new Solution30();

        //System.out.println(Arrays.toString(s.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
        int[][] matrix = s.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}});
        System.out.println(Arrays.deepToString(matrix));
    }

    /**
     * 考虑思路 左边全1 右边全0 可以理解为最大的二进制数
     * 也可以1的下标 小于0的下标
     * @param s
     * @return
     */
    public long minimumSteps(String s) {
        int length = s.length(),step = 0;
        for (int i = 1; i < length - 1; i++) {
            if (s.indexOf(i) == 0){
                step++;
                continue;
            }else {
                step++;
            }
        }

        return step;
    }
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        for(int i = 0; i < n; i++){
            res[i * 2] = nums[i];
            res[i * 2 + 1] = nums[i + n];
        }
        return res;
    }
    public void swap(int i, int[] nums, int n){
        int temp = nums[i];
        nums[i] = nums[i + n];
        nums[i + n] = temp;
    }

    public int[][] transpose(int[][] matrix) {
        int[][] res = new int[matrix[0].length][matrix.length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(i != j){
                    //swap1(i,j,matrix,res);
                    res[j][i] = matrix[i][j];
                }else {
                    res[i][j] = matrix[i][j];
                }
            }
        }
        return res;
    }
}
