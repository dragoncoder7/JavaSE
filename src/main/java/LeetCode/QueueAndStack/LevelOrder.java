package LeetCode.QueueAndStack;

import LeetCode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null){
            return lists;
        }
        TreeNode node = root;
        stack.push(root);

        int level = 0;
        while (!stack.isEmpty()){
            List<Integer> list = new ArrayList<>();
            {   int count = 0;
                list.add(node.val);
                if (node.left != null){
                    stack.push(node.left);
                    count++;
                }
                if (node.right != null){
                    stack.push(node.right);
                    count++;
                }
                node = stack.pop();
                while (count > 0){
                    count--;
                }


            }


            lists.add(list);
        }
        return lists;
    }
}
