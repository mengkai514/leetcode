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

    //方法三，递归
    public static List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root,result);
        return result;
    }

    private static void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left1 = new TreeNode(4);
        TreeNode right1 = new TreeNode(6);
        TreeNode left2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(2);
        root.left = left1;
        root.right = right1;
        left1.left = left2;
        left1.right = right2;
        System.out.println(inorderTraversal3(root));
    }
}
