package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 */
public class FindBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
            list.add(root.val);
        }
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.right != null) {
                queue.add(temp.right);
                if (temp.right.left == null && temp.right.right == null) {
                    list.add(temp.right.val);
                }
            }
            if (temp.left != null) {
                queue.add(temp.left);
                if (temp.left.left == null && temp.left.right == null) {
                    list.add(temp.left.val);
                }
            }
        }
        return list.get(list.size() - 1);
    }

    //只需要记录最后一行第一个节点的数值就可以了。
    public int findBottomLeftValue2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == 0) {
                    res = poll.val;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return res;
    }
}
