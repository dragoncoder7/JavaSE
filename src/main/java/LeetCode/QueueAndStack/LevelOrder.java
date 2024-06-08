package LeetCode.QueueAndStack;

import LeetCode.Tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        LevelOrder levelOrder = new LevelOrder();
        System.out.println(levelOrder.levelOrder1(root));
    }
    public List<List<Integer>> result = new ArrayList<>();

    /**
     *
     * @param root 树
     * @return 层次遍历结果
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        checkfundfs(root,0);
        return result;
    }
    public void checkfundfs(TreeNode node,Integer deep)
    {
        if(node==null){return;}
        deep++;
        if(result.size()<deep)
        {
            List<Integer> item = new ArrayList<>();
            result.add(item);
        }
        result.get(deep-1).add(node.val);
        checkfundfs(node.left,deep);
        checkfundfs(node.right,deep);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null){
            return lists;
        }

        stack.push(root);

        int level = 0;
        while (!stack.isEmpty()){
            level++;
            int size = stack.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.peek();
                assert node != null;
                list.add(node.val);
                if (node.left != null){
                    stack.offerLast(node.left);//添加到队尾
                    //count++;
                }
                if (node.right != null){
                    stack.offerLast(node.right);//添加到队尾
                    //count++;
                }
                stack.poll();//删除队列头元素
            }
            lists.add(list);
        }
        return lists;
    }
}
