package LeetCode.LeetCode75.Tree.BST;

public class leetcode42 {
    public static void main(String[] args) {
        leetcode42 leetcode42 = new leetcode42();
        TreeNode treeNode = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode()));
        System.out.println(leetcode42.deleteNode(treeNode, 3));
    }

    /**
     * deleteNode 就是在给的这个树下 删除一个节点，返回的符合规则的新的树。
     * @date 2025.2.24
     * @author Maoyunlong
     * @param root 给定树
     * @param key 要删除的节点值
     * @return 返回完整的树
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }
        if (root.val > key){
            root = deleteNode(root.left, key);
            return root;
        }
        if (root.val < key){
            root = deleteNode(root.right, key);
            return root;
        }
        //叶子节点
        if (root.left == null && root.right == null){
            return null;
        }

        //单子树节点
        if (root.left == null){
            return root.right;
        }
        if (root.right == null){
            return root.left;
        }

        //双子树节点 两种方法  找当前右子树下最小节点替换root / 找左子树最大节点替换root 同理；满足二叉搜索树规则 左边全小于根节点 右边全大于根节点
        TreeNode deleted = root.right;
        while (deleted.left != null){
            deleted = deleted.left;
        }
        root.right = deleteNode(root.right, deleted.val);
        deleted.left = root.left;
        deleted.right = root.right;
        return deleted;
    }
}
