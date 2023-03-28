package BinaryTree;

/**
 * 654. 最大二叉树
 */
public class ConstructMaximumBinaryTree {
    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        TreeNode root = constructMaximumBinaryTree(nums);
    }
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return findNode(nums, 0, nums.length);
    }
    private static TreeNode findNode(int[] nums, int begin, int end) {
        if (begin >= end) {
            return null;
        }
        if (end - begin == 1) {
            return new TreeNode(nums[begin]);
        }
        int rootIndex = begin;
        int rootValue = nums[rootIndex];
        for (int i = begin; i < end; i++) {
            if (nums[i] > rootValue) {
                rootValue = nums[i];
                rootIndex = i;
            }
        }
        TreeNode root = new TreeNode(rootValue);
        root.left = findNode(nums, begin, rootIndex);
        root.right = findNode(nums, rootIndex + 1 , end);
        return root;
    }
}
