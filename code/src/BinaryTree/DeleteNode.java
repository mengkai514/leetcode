package BinaryTree;

/**
 * 450. 删除二叉搜索树中的节点
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) return null;
            else if (root.left != null && root.right == null) return root.left;
            else if (root.right != null && root.left == null) return root.right;
            else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                return root.right;
            }
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}
