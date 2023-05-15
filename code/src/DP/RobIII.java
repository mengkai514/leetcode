package DP;

/**
 * @author MK
 * @date 2023/5/13 - 20:44
 * 337. 打家劫舍 III
 */
public class RobIII {
    public int rob(TreeNode root) {
        int[] res = robAction(root);
        return Math.max(res[0], res[1]);
    }

    int[] robAction(TreeNode root) {
        int[] res = new int[2];
        if (root == null)
            return res;

        int[] left = robAction(root.left);
        int[] right = robAction(root.right);

        //我们使用一个大小为 2 的数组来表示 int[] res = new int[2] 0 代表不偷，1 代表偷
        //当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
        //当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(2);
        TreeNode right2 = new TreeNode(3);
        TreeNode right1 = new TreeNode(3);
        TreeNode right3 = new TreeNode(1);
        root.left = left1;
        left1.right = right2;
        root.right = right1;
        right1.right = right3;
        RobIII robIII = new RobIII();
        System.out.println(robIII.rob(root));
    }
}

