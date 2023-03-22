package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        int size;
        if (root == null) {
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> resultCount = new ArrayList<>();
            while (size-- > 0) {
                TreeNode temp = queue.peek();
                queue.poll();
                resultCount.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            result.add(resultCount);
        }
        return result;
    }
}
