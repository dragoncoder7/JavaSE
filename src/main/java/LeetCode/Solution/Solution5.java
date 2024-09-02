package LeetCode.Solution;

import java.util.Arrays;

public class Solution5 {

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[] ints = solution5.findDiagonalOrder2(mat);
        //方案二是我自己之前想的规划方案 也是越界了再给它弄回去 但是没想出来具体实现code
        System.out.println(Arrays.toString(ints));
    }
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // 初始化
        int[] ans = new int[m * n];
        int count = 0;

        for (int i = 0; i < m + n - 1; i++) {// 循环次数为对角线个数
                    if (i % 2 == 0){// 偶数对角线从左下到右上
                        //m n i 利用好这三者的关系 来获得每个对角线的起点下标
                        //元素的坐标x y与i的关系为：x+y=i
                        //通过
                        int x = i < m ? i : m - 1;// x:i + y:0 = i;
                        int y = i < m ? 0 : i - m + 1;// x:(m - 1) + y:(i - m + 1) = i
                        while (x >= 0 && y < n) {
                            ans[count] = mat[x][y];
                            count++;
                            x--;
                            y++;
                        }
                    }else {
                        // 奇数对角线从右上到左下
                        int x = i < n ? 0 : i - n + 1;
                        int y = i < n ? i : n - 1;
                        while (x < m && y >= 0){
                            ans[count] = mat[x][y];
                            count++;
                            y--;
                            x++;
                        }
                    }
        }
        return ans;
    }
    public int[] findDiagonalOrder1(int[][] mat) {
        //无法解决 我找不到下半部分的规律了 累子
        int m = mat.length;
        int n =  mat[0].length;
        int[] ans = new int[m * n];
        int count = 0;
        for (int i = 0; i < m + n -1; i++) {
            if ((i % 2) == 0){
                for (int j = i; j >= 0 ; j--) {
                    for (int k = 0; k <= i ; k++) {
                        if (j + k == i){
                            ans[count++] = mat[j][k];
                        }
                    }
                }
            }else {
                for (int j = 0; j <= i ; j++) {
                    for (int k = 0; k <= i ; k++) {
                        if (j + k == i){
                            ans[count++] = mat[j][k];
                        }
                    }
                }
            }
        }
        return  ans;
    }

    public int[] findDiagonalOrder2(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        //存放数组
        int[] ans = new int[m * n];
        //对角线方向次数
        int count = n + m - 1;
        //定义初始化 行标记，列标记，存放数组索引
        int row = 0, col = 0, Index = 0;
        //开始对角线循环
        for (int i = 0; i < count; i++) {
            //判断对角线方向（因题目初始从右上（即i=0）开始）：偶数右上，奇数左下
            if (i % 2 == 0) {
                //右上操作
                while (row >= 0 && col < n) {
                    //将矩阵数存入存放数组
                    ans[Index] = matrix[row][col];
                    //索引后移
                    Index++;
                    //右上规律：行减一，列加一
                    row--;
                    col++;
                }
                //判断是否为越界情况：不越界正常行加一，越界行加二，列减一；
                //（此处不理解的拿张草稿纸将循环中row和col的值遍历写一下对照矩阵图就明白了）
                if (col < n) {
                    row++;
                }
                else {
                    row += 2;
                    col--;
                }
            }
            //左下操作：按规律与右上相反即可
            else {
                while (row < m && col >= 0) {
                    ans[Index] = matrix[row][col];
                    Index++;
                    row++;
                    col--;
                }
                if (row < m) {
                    col++;

                } else {
                    row--;
                    col += 2;
                }
            }
        }
        // 返回存放数组
        return ans;
    }
}
