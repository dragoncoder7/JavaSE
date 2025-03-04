package LeetCode.LeetCode75.Graph.DFS;

import java.util.*;

public class leetcode46 {
    public static void main(String[] args) {
        leetcode46 leetcode46 = new leetcode46();
        List<List<String>> equations = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        List<String> list1 = new ArrayList<>();
        list1.add("b");
        list1.add("c");
        equations.add(list);
        equations.add(list1);
        List<List<String>> queries = getLists();
        double[] values = new double[]{2.0, 3.0};

        System.out.println(Arrays.toString(leetcode46.calcEquation(equations, values, queries)));
    }

    private static List<List<String>> getLists() {
        List<List<String>> queries = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("c");
        List<String> list3 = new ArrayList<>();
        list3.add("b");
        list3.add("a");
        List<String> list4 = new ArrayList<>();
        list4.add("a");
        list4.add("e");
        List<String> list5 = new ArrayList<>();
        list5.add("a");
        list5.add("a");
        List<String> list6 = new ArrayList<>();
        list6.add("x");
        list6.add("x");
        queries.add(list2);
        queries.add(list3);
        queries.add(list4);
        queries.add(list5);
        queries.add(list6);
        return queries;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize = equations.size();

        UnionFind unionFind = new UnionFind(2 * equationsSize);
        // 第 1 步：预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
        Map<String, Integer> hashMap = new HashMap<>(2 * equationsSize);
        int id = 0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation = equations.get(i);
            String var1 = equation.get(0);
            String var2 = equation.get(1);

            if (!hashMap.containsKey(var1)) {
                hashMap.put(var1, id);
                id++;
            }
            if (!hashMap.containsKey(var2)) {
                hashMap.put(var2, id);
                id++;
            }
            unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
        }

        // 第 2 步：做查询
        int queriesSize = queries.size();
        double[] res = new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);

            Integer id1 = hashMap.get(var1);
            Integer id2 = hashMap.get(var2);
            //如果为null 说明该变量不存在在给定的条件变量里 可以直接返回-1
            if (id1 == null || id2 == null) {
                res[i] = -1.0d;
            } else {
                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }

    /**
     * 并查集
     */
    private static class UnionFind {
        /**
         * parent[i] 记录当前节点i指向的根节点下标
         */
        private final int[] parent;

        /**
         * weight[i] 记录当前节点i指向根结点的比例关系
         */
        private final double[] weight;

        /**
         *   初始化数据 n为最大变量个数 实际上可能小于n
         */
        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        /**
         *
         * @param x 变量A对应的唯一hash值
         * @param y 变量B对应的唯一hash值
         * @param value 变量A/B之间的倍数关系 a / b = value a = b * value
         */
        public void union(int x, int y, double value) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            parent[rootX] = rootY;
            // 关系式的推导请见「参考代码」下方的示意图
            // 记录这两个节点之间的系数比值
            weight[rootX] = weight[y] * value / weight[x];
        }

        /**
         * 路径压缩
         *
         * @param x 找该节点的根节点
         * @return 根结点的 id
         */
        public int find(int x) {
            if (x != parent[x]) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        /**
         *
         * @param x 唯一hash对应的节点A
         * @param y 唯一hash对应的节点B
         * @return A/B之间的关系倍数值
         */
        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return weight[x] / weight[y];
            }
            // 上面的为null场景是未知元素所以返回-1 这里的else是不属于同一集合
            // 比如 a/b = 1 c/d = 1 求a/c b/d
            else {
                return -1.0d;
            }
        }
    }
}
