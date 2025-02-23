package LeetCode.LeetCode75.Tree.BFS;

import java.util.*;

public class leetcode39 {
    List<Integer> list = new ArrayList<>();

    private int depth = 0;
    public static void main(String[] args) {
        leetcode39 leetcode39 = new leetcode39();
    }

    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<>();
        int max_depth = -1;

        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> depthStack = new LinkedList<>();
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null) {
                // 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);

                // 如果不存在对应深度的节点我们才插入
                if (!rightmostValueAtDepth.containsKey(depth)) {
                    rightmostValueAtDepth.put(depth, node.val);
                }

                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }

        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }

    public List<Integer> rightSideView1(TreeNode root) {
        dfs(root);
        return list;
    }

    public void dfs(TreeNode root){
        if (root == null){
            return;
        }
        list.add(root.val);
        depth++;
        dfs(root.right);
        dfs(root.left);
    }
}
