package LeetCode.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.LinkedList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    TreeNode(int val, TreeNode left) {
        this.val = val;
        this.left = left;
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
     * @param root 2
     * @return 3
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

    public List<Integer> inorderTraversal1(TreeNode root) {
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

    /**
     * 前序遍历 根右左 迭代算法
     * @param root 根节点
     * @return 返回列表
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> lists = new ArrayList<>();
        if(root == null){
            return lists;
        }
        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()){
            while (root != null){
                lists.add(root.val);
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            root = root.right;
        }
        return lists;
    }

    /**
     * 中序遍历 左根右 迭代算法
     * @param root 1
     * @return 2
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lists = new ArrayList<>();
        if(root == null){
            return lists;
        }
        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            lists.add(root.val);
            root = root.right;
        }
        return lists;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }



    public List<Integer> postorderTraversal22(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list = postOrder(root,list);
        return list;
    }
    public List<Integer> postOrder(TreeNode root,List<Integer> list){
        if(root == null){
            return list;
        }
        postOrder(root.left,list);
        postOrder(root.right,list);
        list.add(root.val);
        return list;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        System.out.println(treeNode.postorderTraversal22(treeNode));
    }
  }
