package LeetCode.LeetCode75.Tree.DFS;


public class leetcode37 {
    public static void main(String[] args) {
        leetcode37 leetcode37 = new leetcode37();
        TreeNode treeNode = new TreeNode(null, new TreeNode(new TreeNode(),new TreeNode(new TreeNode(null, new TreeNode(null, new TreeNode())),new TreeNode())));
//        System.out.println(leetcode37.LongestBinaryTreeCrossPath(treeNode.right,"right"));
//        System.out.println(leetcode37.LongestBinaryTreeCrossPath(treeNode,"left"));
//        System.out.println(leetcode37.LongestBinaryTreeCrossPath(treeNode,"right"));
        System.out.println(leetcode37.longestZigZag1(treeNode));
    }

    public int longestZigZag(TreeNode root) {
        if (root == null){
            return 0;
        }
        int res = Math.max(LongestBinaryTreeCrossPath(root,"left"), LongestBinaryTreeCrossPath(root,"right")) - 1;
        res = Math.max(longestZigZag(root.left), res);
        res = Math.max(longestZigZag(root.right), res);
        return res;
    }

    public int LongestBinaryTreeCrossPath(TreeNode root, String direction){
        int length = 0;
        if (root != null){
            length++;
            if (direction.equals("left")){
                length += LongestBinaryTreeCrossPath(root.left, "right");
            }else {
                length += LongestBinaryTreeCrossPath(root.right, "left");
            }
        }
        return length;
    }


    private int maxLength = 0; // 全局最大值

    public int longestZigZag1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0, 0); // 从根节点开始遍历
        return maxLength;
    }

    private void dfs(TreeNode node, int left, int right) {
        if (node == null) {
            return;
        }
        // 更新全局最大值
        maxLength = Math.max(maxLength, Math.max(left, right));
        // 递归遍历左子树
        dfs(node.left, right + 1, 0); // 向左走，right + 1
        // 递归遍历右子树
        dfs(node.right, 0, left + 1); // 向右走，left + 1
    }
}
