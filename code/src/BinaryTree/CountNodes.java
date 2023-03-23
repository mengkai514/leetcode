package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 222. 完全二叉树的节点个数
 */
public class CountNodes {
    public int countNodes(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int size;
        int result = 0;
        if (root == null) {
            return 0;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            size = queue.size();
            while (size-- > 0) {
                result++;
                TreeNode temp = queue.peek();
                queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return result;
    }

    //根据完全二叉树的特性
    public int countNodesByFeature(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftCount = 0, rightCount = 0;
        while (left != null) {
            left = left.left;
            leftCount++;
        }
        while (right != null) {
            right = right.right;
            rightCount++;
        }
        if (leftCount == rightCount) {
            return (2<<leftCount) - 1;
        }
        return countNodesByFeature(root.left) + countNodesByFeature(root.right) + 1;
    }
}
