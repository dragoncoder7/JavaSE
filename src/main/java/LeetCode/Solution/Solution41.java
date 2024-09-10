package LeetCode.Solution;
import cn.hutool.core.lang.copier.Copier;
public class Solution41 {
    public static void main(String[] args) {
        Solution41 solution41 = new Solution41();
        System.out.println(solution41.checkStraightLine(new int[][]{{2, 1}, {4, 2}, {6, 3}}));
        System.out.println(solution41.clearDigits("cb34"));
        /* 这里输入您的代码 */
    }

    public boolean checkStraightLine(int[][] coordinates) {
        int m = -coordinates[0][0];
        int n = -coordinates[0][1];
        int count = 0;
        float k = 0;

        int A = coordinates[1][1], B = -coordinates[1][0];
        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0] - m, y = coordinates[i][1] - n;
            if (A * x + B * y != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        Copier<StringBuilder> stringBuilderCopier = () -> sb;
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                sb.deleteCharAt(sb.length()-1);
            }else
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
