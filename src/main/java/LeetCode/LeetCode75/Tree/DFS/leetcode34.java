package LeetCode.LeetCode75.Tree.DFS;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class leetcode34 {
    public static void main(String[] args) {
        leetcode34 leetcode34 = new leetcode34();
        TreeNode treeNode1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode treeNode2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(leetcode34.leafSimilar(treeNode1, treeNode2));
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        getLeftVal(root1,list1);
        getLeftVal(root2,list2);
        if (list1.size() == list2.size()){
            for (int i = 0; i < list2.size(); i++) {
                if (!Objects.equals(list2.get(i), list1.get(i))){
                    return false;
                }
            }
            return true;
        }
//        System.out.println("list1:"+list1);
//        System.out.println("list2:"+list2);
        return false;
    }
    public int getLeft(TreeNode treeNode){
        if (treeNode.left == null && treeNode.right == null){
            return treeNode.val;
        }
        return 0;
    }

    public void getLeftVal(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null){
            return ;
        }
        if (treeNode.left == null && treeNode.right == null){
            list.add(treeNode.val);
        }
        getLeftVal(treeNode.left,list);
        getLeftVal(treeNode.right,list);
    }
}
