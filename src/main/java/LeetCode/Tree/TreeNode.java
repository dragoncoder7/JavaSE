package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public List<Integer> preorderTraversal0(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }


    /**
     * 前序遍历 根左右
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> lists = new ArrayList<>();
        if (root == null){
            return lists;
        }
        lists.add(root.val);
        if (root.left != null) {
            lists.addAll(preorderTraversal(root.left));
        }
        if (root.right != null) {
            lists.addAll(preorderTraversal(root.right));
        }
        return lists;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lists = new ArrayList<>();
        if (root == null){
            return lists;
        }

        if (root.left != null) {
            lists.addAll(inorderTraversal(root.left));
        }

        lists.add(root.val);

        if (root.right != null) {
            lists.addAll(inorderTraversal(root.right));
        }
        return lists;
    }
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        System.out.println(treeNode.preorderTraversal(treeNode));
    }

  }
