package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution14 {
    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        List<List<Integer>> lists = solution14.generate(5);
        System.out.println(lists);
        //[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,
    }

    /**杨辉三角
     * @param numRows 给定一个非负整数 numRows，
     * @return 生成「杨辉三角」的前 numRows 行。
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows == 1) {
            List<Integer> list = new ArrayList<>(){};
            list.add(1);
            lists.add(list);
            return lists;
        }
        for (int i = 0; i < numRows; i++){
            List<Integer> list = new ArrayList<>(){};
            for (int j = 0; j < i+1; j++){
                if (j == 0 || j == i){
                    list.add(1);
                }else {
                    list.add(lists.get(i-1).get(j)+lists.get(i-1).get(j-1));
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
