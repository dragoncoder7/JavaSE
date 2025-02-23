package LeetCode.LeetCode75.Tree.DFS;


public class leetcode35 {
    public static void main(String[] args) {
        leetcode35 leetcode35 = new leetcode35();
        TreeNode treeNode = new TreeNode(3, new TreeNode(1, new TreeNode(3), null), new TreeNode(4, new TreeNode(1), new TreeNode(5)));
        System.out.println(leetcode35.goodNodes(treeNode));
    }
    public int goodNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        return DepthSearchFirst(root, root.val);
        //DepthSearchFirst(root.left,root.val) + DepthSearchFirst(root.right,root.val) + 1;
    }

    /**
     * 我知道要这样去写 但是我不知道我这里其实就是用了深度优先遍历 
     * DepthSearchFirst
     * @param root
     * @param max
     * @return
     */
    public int DepthSearchFirst(TreeNode root, int max){
        int res = 0;
        if (root == null){
            return 0;
        }
        if (root.val >= max){
            res++;
            max = root.val;
        }
        res += DepthSearchFirst(root.left,max);
        res += DepthSearchFirst(root.right,max);
        return res;
    }
}
