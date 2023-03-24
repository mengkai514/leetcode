package BinaryTree;

/**
 * 110. 平衡二叉树
 */
public class IsBalanced {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode left1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        TreeNode right2 = new TreeNode(3);
        TreeNode left3 = new TreeNode(4);
        TreeNode right3 = new TreeNode(4);
        root.right = right1;
        root.left = left1;
        left1.left = left2;
        left1.right = right2;
        left2.left = left3;
        left2.right = right3;
        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        // 左右子树高度差大于1，return -1表示已经不是平衡树了
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
