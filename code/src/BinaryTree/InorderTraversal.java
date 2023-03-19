package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }

    //方法二，统一迭代
    public List<Integer> inorderTraversal2(TreeNode root) {
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
                //中序操作，反向入栈
                if (node.right != null) stack.push(node.right);
                stack.push(node);
                stack.push(null); //代表该节点尚未处理
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
