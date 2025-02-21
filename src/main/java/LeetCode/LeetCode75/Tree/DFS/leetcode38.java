package LeetCode.LeetCode75.Tree.DFS;

import LeetCode.LeetCode75.Tree.TreeNode;

public class leetcode38 {

    private TreeNode treeNode;
    public leetcode38(){
        this.treeNode = null;
    }
    public static void main(String[] args) {
        leetcode38 leetcode38 = new leetcode38();
        System.out.println();
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p , q);
        return treeNode;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if (root == null){
            return false;
        }
        boolean lchild = dfs(root.left, p , q);
        boolean rchild = dfs(root.right, p , q);
        if ((lchild && rchild) || ((root.val == p.val || root.val == q.val) && (lchild || rchild))){
            this.treeNode = root;
        }
        return lchild || rchild || (root.val == p.val || root.val == q.val);
    }

}
