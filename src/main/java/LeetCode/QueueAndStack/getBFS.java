package LeetCode.QueueAndStack;

import LeetCode.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class getBFS {
    public static void main(String[] args) {

    }
    public int BFS(TreeNode root,TreeNode target) {
        Queue<TreeNode> queue = new LinkedList<>();
        int step = 0;
        queue.add(root);

        while (!queue.isEmpty()){
            step += 1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur == null){
                    continue;
                }
                if (cur.val == target.val){
                    return step;
                }
                queue.add(cur.left);
                queue.add(cur.right);
                queue.remove();
            }
        }
        return -1;
    }
}
