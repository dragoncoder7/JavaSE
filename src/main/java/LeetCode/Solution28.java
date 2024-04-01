package LeetCode;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class Solution28 {
    public static void main(String[] args) throws ClassNotFoundException {
        Solution28 s = new Solution28();
        System.out.println(s.checkStraightLine(new int[][]{{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}}));
    }
    public static double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        double sum = 0;
        for (int i :
                salary) {
            sum += i;
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        return (sum-min-max) / (salary.length-2);
    }
    public static boolean lemonadeChange(int[] bills) {
        boolean[] tags = new boolean[bills.length];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < bills.length;i++){
            if(bills[i] == 5){
                tags[i] = true;
                list.add(bills[i]);
            }else{
                int change = bills[i] - 5;//5 15
                if(list.contains(change)){
                    list.add(bills[i]);
                    list.remove(Integer.valueOf(change));
                    tags[i] = true;
                }else {
                    if ((list.contains(5) && list.contains(10))){
                        list.remove((Integer) 5);
                        list.remove((Integer) 10);
                        list.add(bills[i]);
                        tags[i] = true;
                    }
                }
            }
        }
        for (boolean b :
                tags) {
            if (!b){
                return false;
            }
        }
        return true;
    }
    public boolean checkStraightLine(int[][] coordinates) {
        boolean tag = true;
        int x1 = coordinates[0][0], y1 = coordinates[0][1];
        int xn = coordinates[1][0], yn = coordinates[1][1];
        int k = (yn - y1) / (xn - x1);
        int b = y1 - k * x1;
        if(coordinates.length == 2){
            return true;
        }
        for(int i = 2; i < coordinates.length; i++){
            xn = coordinates[i][0]; yn = coordinates[i][1];
            if((k * xn + b) != yn){
                tag = false;
                break;
            }
        }
        return tag;
    }
}
