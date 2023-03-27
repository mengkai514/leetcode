package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 113.路径总和ii
 */
public class PathSum2 {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, 0, sum);
        return res;
    }
    public static void dfs(TreeNode root, int num, int sum){
        if(root == null) return;
        num += root.val;
        list.add(root.val);
        if(num == sum && root.left == null && root.right == null) res.add(new ArrayList(list));
        dfs(root.left, num, sum);
        dfs(root.right, num, sum);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode l1 = new TreeNode(4);
        TreeNode r1 = new TreeNode(8);
        TreeNode l2 = new TreeNode(11);
        TreeNode r2 = new TreeNode(4);
        TreeNode r1l2 = new TreeNode(13);
        TreeNode l3 = new TreeNode(7);
        TreeNode r3 = new TreeNode(2);
        TreeNode r2l3 = new TreeNode(5);
        TreeNode r2r3 = new TreeNode(1);
        root.left = l1; root.right = r1;
        l1.left = l2;
        r1.left = r1l2; r1.right = r2;
        l2.left = l3; l2.right = r3;
        r2.left = r2l3; r2.right = r2r3;
        System.out.println(pathSum(root,22));;
    }
}
