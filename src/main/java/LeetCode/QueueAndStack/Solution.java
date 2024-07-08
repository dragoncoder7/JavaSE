package LeetCode.QueueAndStack;

import LeetCode.Tree.TreeNode;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.numSquares(12));
        System.out.println(solution.paintWalls(new int[]{26,53,10,24,25,20,63,51},new int[]{1,1,1,1,2,2,2,1}));
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //Deque 双端队列  LinkedList
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }

    /**
     * * 200. 岛屿数量
     * @param grid 二维数组 岛屿
     * @return 岛屿数量
     */
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '2';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }

    public int numSquares(int n) {
        int i = 1;
        List<Integer> list = new ArrayList<>();
        while(true){
            if(Math.pow(i,2) < n && Math.pow(i + 1,2) > n){
                list.add(i);
                n = (int) (n - Math.pow(i,2));
                i = 1;
            }
            if(Math.pow(i,2) == n){
                list.add(i);
                break;
            }
            i++;
        }
        return list.size();
    }
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[] f = new int[n * 2 + 1];
        Arrays.fill(f, Integer.MAX_VALUE / 2);
        f[n] = 0;
        for (int i = 0; i < n; ++i) {
            int[] g = new int[n * 2 + 1];
            Arrays.fill(g, Integer.MAX_VALUE / 2);
            for (int j = 0; j <= n * 2; ++j) {
                // 付费
                g[Math.min(j + time[i], n * 2)] = Math.min(g[Math.min(j + time[i], n * 2)], f[j] + cost[i]);
                // 免费
                if (j > 0) {
                    g[j - 1] = Math.min(g[j - 1], f[j]);
                }
            }
            f = g;
        }
        int ans = f[n];
        for (int i = n + 1; i <= n * 2; i++) {
            ans = Math.min(ans, f[i]);
        }
        return ans;
    }
}
