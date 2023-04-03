package BinaryTree;

/**
 * 669. 修剪二叉搜索树
 */
public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) {
            root.right = trimBST(root.right, low, high);
            return root.right;
        }
        if (root.val > high) {
            root.left = trimBST(root.left, low, high);
            return root.left;
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
