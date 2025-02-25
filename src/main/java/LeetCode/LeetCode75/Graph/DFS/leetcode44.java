package LeetCode.LeetCode75.Graph.DFS;

public class leetcode44 {
    private int[][] isConnected;

    private boolean[] visited;

    public static void main(String[] args) {
        leetcode44 leetcode44 = new leetcode44();
        System.out.println();
    }
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        visited = new boolean[cities];
        this.isConnected = isConnected;
        int provinces = 0;
        for (int i = 0; i < cities; i++) {
            if (!visited[i]){
                dfs(cities,i);
                provinces++;
            }
        }
        return provinces;
    }

    public void dfs(int cities, int i){
        for (int j = 0; j < cities; j++) {
            if (isConnected[i][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(cities, j);
            }
        }
    }


}
