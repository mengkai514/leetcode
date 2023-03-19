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

    //方法二，统一迭代
    public List<Integer> postorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                stack.pop(); //先把中间节点取出，避免重复操作
                //后序操作，反向入栈
                stack.push(node);
                stack.push(null); //代表该节点尚未处理
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            } else {
                stack.pop(); //先取出null
                node = stack.peek();
                stack.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}
