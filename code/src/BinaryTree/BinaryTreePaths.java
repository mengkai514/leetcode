package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 257. 二叉树的所有路径
 */
public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        TreeNode right2 = new TreeNode(5);
        root.right = right1;
        root.left = left1;
        left1.right = right2;
        System.out.println(binaryTreePaths(root));
    }
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        Stack<Object> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        stack.push(root.val + "");
        while (!stack.isEmpty()) {
            String path = (String) stack.pop();
            TreeNode temp = (TreeNode) stack.pop();
            if (temp.left == null && temp.right == null) {
                result.add(path);
            }
            if (temp.right != null) {
                stack.push(temp.right);
                stack.push(path + "->" + temp.right.val);
            }
            if (temp.left != null) {
                stack.push(temp.left);
                stack.push(path + "->" + temp.left.val);
            }
        }
        return result;
    }

    public static List<String> binaryTreePaths2(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> paths = new ArrayList<>();
        traversal(root,paths,result);
        return result;
    }

    private static void traversal(TreeNode root, List<Integer> paths, List<String> result) {
        paths.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            result.add(sb.toString());
            return;
        }
        if (root.left != null) {
            traversal(root.left,paths,result);
            paths.remove(paths.size() - 1);
        }
        if (root.right != null) {
            traversal(root.right,paths,result);
            paths.remove(paths.size() - 1);
        }
    }
}
