package BinaryTree;

/**
 * 538. 把二叉搜索树转换为累加树
 */
public class ConvertBST {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        root.right = convertBST(root.right);
        sum += root.val;
        root.val = sum;
        root.left = convertBST(root.left);
        return root;
    }
}
