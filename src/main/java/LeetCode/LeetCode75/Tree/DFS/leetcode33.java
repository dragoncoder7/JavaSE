package LeetCode.LeetCode75.Tree.DFS;

public class leetcode33 {
    public static void main(String[] args) {
        leetcode33 leetcode33 = new leetcode33();
        System.out.println();
    }
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right) + 1;
    }
}
