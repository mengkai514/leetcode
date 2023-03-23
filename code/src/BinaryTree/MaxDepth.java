package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) {
            queue.offer(root);
        }
        int size;
        int count = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            while (size-- > 0) {
                TreeNode temp = queue.poll();
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            count++;
        }
        return count;
    }
}
