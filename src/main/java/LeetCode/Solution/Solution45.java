package LeetCode.Solution;

import java.util.*;

public class Solution45 {
    public static void main(String[] args) {
        double a = 10;
        double b = 10;
        System.out.println((double)(10 >> 10));
        /* 这里输入您的代码 */ 
    }
    public static int countSpecialNumbers(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (i <= 10){
                count++;
                continue;
            }
            if (judgeSpecialNumber(i)){
                count++;
            }
        }
        return count ;
    }

    /**
     * 判断一个数字是不是特殊整数 每一个位上的数字不能重复 还要优化这个方法
     * @param n
     * @return
     */
    public static boolean judgeSpecialNumber(int n){
        int length = String.valueOf(n).length();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++){
            int individual = (int) (n / Math.pow(10,i) % 10);
            if (list.contains(individual)){
                return false;
            }else {
                list.add(individual);
            }
        }
        return true;
    }

    public static boolean judgeSpecialNumber1(int n){
        int[] counts = new int[10];
        String nn = String.valueOf(n);
        int length = String.valueOf(n).length();
        for (int i = 0; i < length; i++){
            int individual = nn.charAt(i) - '0';
            counts[individual]++;
            if (counts[individual] >= 2){
                return false;
            }
        }
        return true;
    }
}
