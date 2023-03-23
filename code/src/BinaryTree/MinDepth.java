package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (root.left == null) {
            return rightDepth + 1;
        }
        if (root.right == null) {
            return leftDepth + 1;
        }
        return Math.min(leftDepth, rightDepth) + 1;
    }

    //层序遍历
    public static int minDepth2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) {
            queue.offer(root);
        }
        int size;
        int count = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            count++;
            while (size-- > 0) {
                TreeNode temp = queue.poll();
                if(temp.left == null && temp.right == null) {
                    return count;
                }
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(4);
        TreeNode right2 = new TreeNode(3);
        TreeNode left3 = new TreeNode(6);
        TreeNode right3 = new TreeNode(5);
        root.right = right1;
        right1.left = left2;
        right1.right = right2;
        right2.left = left3;
        right2.right = right3;
        System.out.println(minDepth2(root));
    }
}
