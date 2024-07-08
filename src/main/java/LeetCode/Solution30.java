package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 狸生丶
 * @date 2024-06-11 16:13
 * @description 「新」动计划 · 编程入门 20题
 */
public class Solution30 {
    public static void main(String[] args) {
        /* 这里输入您的代码 */
        String result;
        result = String.valueOf(1);
        /*System.out.println(result);
        Solution30 s = new Solution30();

        System.out.println(Arrays.toString(s.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
        int[][] matrix = s.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}});
        System.out.println(Arrays.deepToString(matrix));
        System.out.println("maxScore:"+s.maxScore("011101"));
        System.out.println(s.vowelStrings(new String[]{"are","amy","u"},0,2));
        System.out.println(s.peakIndexInMountainArray(new int[]{0,1,0}));
        System.out.println(s.minimumSteps("011101"));*/
        //s.swap(1,new int[]{1,2,3},1);
        String StartTime = "2024-6-8 07:40";
        String[] res = StartTime.split(" ");
        for (String t:
             res) {
            System.out.println(t);
        }
        System.out.println("res:"+Arrays.toString(res));
        String OverTime = "2024-6-8 08:10";
        String beginDate = StartTime.substring(0,StartTime.length()-6);//请假时间日期部分
        String beginTime = StartTime.substring(StartTime.length()-5);//请假时间小时部分
        String endDate = OverTime.substring(0,StartTime.length()-6);//请假时间日期部分
        String endTime = OverTime.substring(StartTime.length()-5);//请假时间小时部分
        //String beginDate = StartTime.substring(0,8);//请假时间日期部分
        System.out.println(beginDate);
        //String beginTime = StartTime.substring(9);//请假时间小时部分
        System.out.println(beginTime);
        //String endDate = OverTime.substring(0,8);//请假时间日期部分
        System.out.println(endDate);
        //String endTime = OverTime.substring(9);//请假时间小时部分
        System.out.println(endTime);
        System.out.println("SELECT\n" +
                "	* \n" +
                "FROM\n" +
                "	k20 a \n" +
                "WHERE\n" +
                "	a.k2008 = ( SELECT CONVERT ( DATETIME, '1900-01-01 ' + '"+beginTime+"' ) ) \n" +
                "	AND a.k2009 = ( SELECT CONVERT ( DATETIME, '1900-01-01 ' + '"+endTime+"' ) ) \n" +
                "	AND a.k2006 = ( SELECT CONVERT ( DATETIME, '"+beginDate+"', 120 ) ) \n" +
                "	AND a.k2007 = ( SELECT CONVERT ( DATETIME, '"+endDate+"', 120 ) ) \n" +
                "	AND a.A0188 = "+5);
    }

    /**
     * 考虑思路 左边全1 右边全0 可以理解为最大的二进制数
     * 也可以1的下标 小于0的下标
     * @param s 入参
     * @return 出参
     */
    public long minimumSteps(String s) {
        int length = s.length(),step = 0;
        for (int i = 1; i < length - 1; i++) {
            step++;
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

    public int maxScore(String s) {
        int score = 0;
        for (int i = 1; i < s.length(); i++) {
            int left = 0,right = 0;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == '0'){
                    left++;
                }
            }
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '1'){
                    right++;
                }
            }
            score = Math.max(score, (left + right));
            //System.out.println(a + " "+ b);
        }
        return score;
    }
    public int vowelStrings(String[] words, int left, int right) {
        Set<Character> vowels = new HashSet<>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }};
        int ans = 0;
        for (int i = left; i <= right; ++i) {
            String word = words[i];
            if (vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1))) {
                ++ans;
            }
        }
        return ans;
    }
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length, ans = 0;
        while (left < right) {
            int mid = left + right / 2;
            if (arr[mid] > arr[mid + 1]){
                ans = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public int addDigits(int num) {
        //6543213
        return (num - 1) % 9 + 1;
    }
}
