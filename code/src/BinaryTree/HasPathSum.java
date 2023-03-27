package BinaryTree;

import java.util.Stack;

/**
 * 112. 路径总和
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        stack.push(root);
        stack1.push(root.val);
        while (!stack.isEmpty()) {
            int size = stack.size();
            while (size-- > 0) {
                TreeNode temp = stack.pop();
                int sum = stack1.pop();
                if (temp.left == null && temp.right == null && sum == targetSum) {
                    return true;
                }
                if (temp.right != null) {
                    stack.push(temp.right);
                    stack1.push(sum + temp.right.val);
                }
                if (temp.left != null) {
                    stack.push(temp.left);
                    stack1.push(sum + temp.left.val);
                }
            }
        }
        return false;
    }
}
