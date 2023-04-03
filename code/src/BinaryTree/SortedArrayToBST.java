package BinaryTree;

/**
 * 108. 将有序数组转换为二叉搜索树
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return constructBST(nums, 0, nums.length);
    }

    private TreeNode constructBST(int[] nums, int begin, int end) {
        if (begin >= end) {
            return null;
        }
        int rootIndex = (begin + end) / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = constructBST(nums, begin, rootIndex);
        root.right = constructBST(nums, rootIndex + 1, end);
        return root;
    }
}
