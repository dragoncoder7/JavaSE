package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution15 {
    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        System.out.println(solution15.getRow1(5));
    }

    /**
     * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     * @param rowIndex rowIndex
     * @return 返回行
     */
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++){
            List<Integer> list = new ArrayList<>() {
            };
            for (int j = 0; j < i + 1; j++){
                if (j == 0 || j == i){
                    list.add(1);
                }else {
                    list.add(lists.get(i-1).get(j) + lists.get(i-1).get(j-1));
                }
            }
            lists.add(list);
        }
        return lists.get(rowIndex);
    }

    /**
     *  方法二：获得第一行的 再获得第二行的数据 再通过第二行的获得第三行的 以此类推
     * @param rowIndex 行下标
     * @return 返回行数据
     */
    public List<Integer> getRow1(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }
}
