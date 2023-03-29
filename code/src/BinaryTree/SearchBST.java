package BinaryTree;

import java.util.Stack;

/**
 * 700. 二叉搜索树中的搜索
 */
public class SearchBST {
    /**
     * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
     * 它的左、右子树也分别为二叉搜索树
     */
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null)
            if (val < root.val) root = root.left;
            else if (val > root.val) root = root.right;
            else return root;
        return null;
    }

    //迭代
    public TreeNode searchBST2(TreeNode root, int val) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.val == val) {
                return temp;
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }
        }
        return null;
    }

    //递归 + 搜索树特性（）
    public TreeNode searchBST3(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        }
        else {
            return searchBST(root.right, val);
        }
    }

    // 递归，普通二叉树
    public TreeNode searchBST4(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        TreeNode left = searchBST(root.left, val);
        if (left != null) {
            return left;
        }
        return searchBST(root.right, val);
    }
}
