package LeetCode.LeetCode75.Graph.DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode43 {
    public static void main(String[] args) {
        leetcode43 leetcode43 = new leetcode43();
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room1 = new ArrayList<>();
        room1.add(1);
        room1.add(3);
        List<Integer> room2 = new ArrayList<>();
        room2.add(1);
        room2.add(4);
        List<Integer> room3 = new ArrayList<>();
        room3.add(2);
        room3.add(3);
        room3.add(4);
        room3.add(1);
        List<Integer> room4 = new ArrayList<>();
        List<Integer> room5 = new ArrayList<>();
        room5.add(4);
        room5.add(3);
        room5.add(2);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(room5);
        System.out.println(leetcode43.canVisitAllRooms1(rooms));
        System.out.println(leetcode43.canVisitAllRooms(rooms));
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //用set记录可访问的room
        Set<Integer> canAccess = new HashSet<>();
        //用set记录已访问过的room
        Set<Integer> visited = new HashSet<>();
        canAccess.add(0);
        while (canAccess.size() != visited.size()){
            //为防止发生ConcurrentModificationException异常 建临时集合
            Set<Integer> Access = new HashSet<>();
            for (int i : canAccess) {
                //过滤已经访问过的
                if (!visited.contains(i)){
                    visited.add(i);
                    List<Integer> room = rooms.get(i);
                    Access.addAll(room);
                }
            }
            canAccess.addAll(Access);
        }
        return visited.size() == rooms.size();
    }

    boolean[] vis;//定义访问过的room
    int num;//定义已访问过的room数量

    public boolean canVisitAllRooms1(List<List<Integer>> rooms) {
        int n = rooms.size();
        num = 0;
        vis = new boolean[n];
        dfs(rooms, 0);
        return num == n;
    }

    /*
    优化 把rooms作为全局变量
    不需要每次递归带上 减少递归栈占用内存
    private List<List<Integer>> rooms;
    this.rooms = rooms;
    */
    public void dfs(List<List<Integer>> rooms, int x) {
        vis[x] = true;
        num++;
        for (int it : rooms.get(x)) {
            //未访问过才访问
            if (!vis[it]) {
                dfs(rooms, it);
            }
        }
    }

}
