package LeetCode.LeetCode75.Tree.BFS;

import java.util.*;

public class leetcode40 {
    public static void main(String[] args) {
        leetcode40 leetcode40 = new leetcode40();
        TreeNode treeNode = new TreeNode(1, new TreeNode(7, new TreeNode(7), new TreeNode(-8)), new TreeNode(0));
        System.out.println(leetcode40.maxLevelSum(treeNode));
    }

    /**
     * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
     * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
     * @author maoyunInteger
     * @date 2025/02/21
     * @param root 节点
     * @return  层sum最大值的最小层号
     */
    public int maxLevelSum1(TreeNode root) {
        int ans = 1, maxSum = root.val;
        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        for (int level = 1; !q.isEmpty(); ++level) {
            List<TreeNode> nq = new ArrayList<>();
            int sum = 0;
            for (TreeNode node : q) {
                sum += node.val;
                if (node.left != null) {
                    nq.add(node.left);
                }
                if (node.right != null) {
                    nq.add(node.right);
                }
            }
            if (sum > maxSum) {
                maxSum = sum;
                ans = level;
            }
            q = nq;
        }
        return ans;
    }


    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> tree = new LinkedList<>();
        tree.add(root);
        int max = Integer.MIN_VALUE;
        int res = 1;
        int level = 1;
        while (!tree.isEmpty()){
            int size = tree.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = tree.poll();
                sum += poll.val;
                if (poll.left != null) {
                    tree.add(poll.left);
                }
                if (poll.right != null) {
                    tree.add(poll.right);
                }
            }
            if (sum > max) {
                max = sum;
                res = level;
            }
            level++;
        }
        return res;
    }
}
