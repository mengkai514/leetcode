package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 404. 左叶子之和
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.left != null) {
                queue.add(temp.left);
                if (temp.left.left == null && temp.left.right == null) {
                    result += temp.left.val;
                }
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return result;
    }
}
