package LeetCode.LeetCode75.Graph.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode47 {
    private final int[] row = new int[]{-1, 1, 0, 0};
    private final int[] col = new int[]{0, 0, -1, 1};
    public static void main(String[] args) {
        leetcode47 leetcode47 = new leetcode47();
        System.out.println();
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{entrance[0], entrance[1]});
        maze[entrance[0]][entrance[1]] = '+';
        int res = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = node[0] + row[j];
                    int y = node[1] + col[j];
                    if (x < 0 || y < 0 || x >= m || y >= n || maze[x][y] == '+'){
                        continue;
                    }
                    if (x == 0 || y == 0 || x == m - 1 || y == n - 1){
                        return res;
                    }
                    queue.add(new int[]{x, y});
                    maze[x][y] = '+';
                }
            }
        }
        return -1;
    }
}
