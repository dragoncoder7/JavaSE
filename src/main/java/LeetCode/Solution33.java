package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution33 {
    public static void main(String[] args) {
        /* 这里输入您的代码 */
        int[] mountain = {1,4,3,8,5};
        Solution33 solution33 = new Solution33();
        //System.out.println(solution33.findPeaks(mountain));
        int[][] mat = {{1,2,3,4},
                        {4,5,6,7},
        {7,8,9,10},{10,11,12,13}};
        //System.out.println(solution33.diagonalSum(mat));
        System.out.println(Arrays.toString(solution33.distributeCandies(10, 3)));
    }
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            int before = i - 1;
            int after = i + 1;
            if (mountain[i] > mountain[before] && mountain[i] > mountain[after]){
                list.add(i);
            }
        }
        return list;
    }
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int sum = 0;
        for(int i = 1; i < Integer.MAX_VALUE; i++){
            int index = (i - 1) % num_people ;
            if(sum + i > candies){
                res[index] += candies - sum;
                break;
            }
            res[index] += i;
            sum += i;
        }
        return res;
    }
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;
        if (n % 2 == 0){
            for (int i = 0; i < n; i++){
                sum += mat[i][i];
                sum += mat[i][n - i];
            }
            return sum;
        }
        /*for(int i = 0,j = n; i < n; i++){
            a00 -> ann a0n -> an0
            if(i == j -1)
        }
        System.out.println(Arrays.deepToString(res));
        return 0;*/
        //((0,0),(1,1),(2,2))
        return sum;
    }
}
