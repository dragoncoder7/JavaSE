package LeetCode.LeetCode75.Graph.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode48 {
    public static void main(String[] args) {
        leetcode48 leetcode48 = new leetcode48();
        int[][] grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(leetcode48.orangesRotting(grid));
    }

    private final int[] row = new int[]{-1, 1, 0, 0};
    private final int[] col = new int[]{0, 0, -1, 1};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        int goodNums = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
                if (grid[i][j] == 1){
                    goodNums ++;
                }
            }
        }
        if (goodNums == 0){
            return 0;
        }
        while (!queue.isEmpty()){
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] orange = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = orange[0] + row[j];
                    int y = orange[1] + col[j];
                    if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0){
                        continue;
                    }
                    if (grid[x][y] == 1){
                        queue.add(new int[]{x, y});
                        grid[x][y] = 2;
                        goodNums--;
                    }
                }
            }
            if (goodNums == 0){
                return res;
            }
        }
        return -1;
    }
}
