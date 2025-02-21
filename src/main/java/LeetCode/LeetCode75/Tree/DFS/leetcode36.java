package LeetCode.LeetCode75.Tree.DFS;

import LeetCode.LeetCode75.Tree.TreeNode;

public class leetcode36 {
    public static void main(String[] args) {
        leetcode36 leetcode36 = new leetcode36();
        TreeNode treeNode = new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(3), new TreeNode(-2)
                        ),
                        new TreeNode(2, null, new TreeNode(1))),
                new TreeNode(-3, null, new TreeNode(11)));
        System.out.println(leetcode36.pathSum(treeNode,8));
    }
    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = rootSum(root, targetSum);
        //每个节点都算
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int sumTreeNode(TreeNode root, int targetSum, int temp){
        int res = 0;
        if (root == null){
            return res;
        }
        temp = temp + root.val;
        if (temp == targetSum){
            res++;
        }
//        if (temp > targetSum){
//            return 0;
//        }
        res += sumTreeNode(root.left, targetSum, temp);
        res += sumTreeNode(root.right, targetSum, temp);
        return res;
    }
    //算一个节点延伸下的符合target的值
    public int rootSum(TreeNode root, long targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }

        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }
}
