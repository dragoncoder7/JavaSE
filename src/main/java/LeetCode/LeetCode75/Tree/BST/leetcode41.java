package LeetCode.LeetCode75.Tree.BST;


public class leetcode41 {
    private int res;
    private TreeNode root;
    public static void main(String[] args) {
        leetcode41 leetcode41 = new leetcode41();

        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1) ,new TreeNode(3)), new TreeNode(7));
        System.out.println(leetcode41.searchBST(root,2));
    }

    /**
     * 利用特性，排序有序，左边的值一定是小于根节点的，右边的一定是大于根节点的值的。
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        }
        return searchBST(val < root.val ? root.left : root.right, val);
    }

    /**
     * 我这是遍历完了
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST1(TreeNode root, int val) {
        res = val;
        dfs(root);
        return this.root;
    }
    public void dfs(TreeNode root){
        if (root == null){
            return ;
        }
        if (root.val == res){
            this.root = root;
        }
        dfs(root.left);
        dfs(root.right);
    }
}
