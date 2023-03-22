package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. 翻转二叉树
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int size;
        if (root == null) {
            return null;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                swap(node);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return root;
    }
    public void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
