package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 * 入栈：中 左 右 出栈：中 右 左 反转：左 右 中
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            result.add(temp.val);
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
