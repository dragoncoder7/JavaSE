package LeetCode.LeetCode75.Graph.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode45 {

    boolean[] visited;
    int[][] connections;

    int begin;

    int reverse;
    public static void main(String[] args) {
        leetcode45 leetcode45 = new leetcode45();
        int[][] connections = new int[5][2];
        connections[0][0] = 0;
        connections[0][1] = 1;
        connections[1][0] = 1;
        connections[1][1] = 3;
        connections[2][0] = 2;
        connections[2][1] = 3;
        connections[3][0] = 4;
        connections[3][1] = 0;
        connections[4][0] = 4;
        connections[4][1] = 5;
        System.out.println(leetcode45.minReorder1(6, connections));
    }

    public int minReorder(int n, int[][] connections) {
        this.reverse = 0;
        visited = new boolean[n];
        this.connections = connections;
        for (int i = 0; i < n - 1; i++) {
            if (!visited[i]){
                begin = connections[i][0];
                dfs(i);
            }
        }
        return reverse;
    }

    public void dfs(int i){
        if (!visited[i]){
            if (begin == 0){
                reverse++;
            }
            visited[connections[i][0]] = true;
            dfs(connections[i][1]);
        }
    }

    // [[0,1],[1,3],[2,3],[4,0],[4,5]]
    public int minReorder1(int n, int[][] connections) {
        List<int[]>[] e = new List[n];
        for (int i = 0; i < n; i++) {
            e[i] = new ArrayList<>();
        }
        for (int[] edge : connections) {
            //System.out.println("这里是每个Connection的内部："+Arrays.toString(edge));
            // 比如当前是[2,3]
            e[edge[0]].add(new int[]{edge[1], 1});//添加节点2到节点3的路径 为1 表示真实存在
            e[edge[1]].add(new int[]{edge[0], 0});//添加节点3到节点2的反向路径 为0 表示不是真实存在的
        }
        return dfs1(0, -1, e);
    }

    public int dfs1(int x, int parent, List<int[]>[] e) {
        int res = 0;
        //遍历节点x下的所有路径（一定是两条）
        for (int[] edge : e[x]) {
            if (edge[0] == parent) {
                continue;
            }
            res += edge[1] + dfs1(edge[0], x, e);
        }
        return res;
    }

}
