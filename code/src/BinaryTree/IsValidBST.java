package BinaryTree;

/**
 * 98. 验证二叉搜索树
 */
public class IsValidBST {
    private static TreeNode pre = null;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(4);
        TreeNode left2 = new TreeNode(3);
        TreeNode right2 = new TreeNode(6);
        root.left = left1;
        root.right = right1;
        right1.left = left2;
        right1.right = right2;
        System.out.println(isValidBST(root));
    }

    //二叉搜索树通过中序遍历会得到一个升序的数组
    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Boolean left = isValidBST(root.left);

        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;

        Boolean right = isValidBST(root.right);
        return left && right;
    }
}
