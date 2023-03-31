package BinaryTree;

/**
 * 530. 二叉搜索树的最小绝对差
 */
public class GetMinimumDifference {
    private static TreeNode pre = null;
    static int result = Integer.MAX_VALUE;
    public static int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMinimum(root);
        return result;
    }

    private static void getMinimum(TreeNode root) {
        if (root == null) {
            return;
        }
        getMinimum(root.left);
        if (pre != null) {
            result = Math.min(result,root.val - pre.val);
        }
        pre = root;
        getMinimum(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(6);
        TreeNode left2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(3);
        root.left = left1;
        root.right = right1;
        left1.left = left2;
        left1.right = right2;
        System.out.println(getMinimumDifference(root));
    }
}
