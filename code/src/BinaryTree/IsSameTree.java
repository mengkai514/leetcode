package BinaryTree;

/**
 * 100. 相同的树
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null){
            return q == null;
        }
        return q != null && p.val == q.val && isSameTree(p.left,q.left) &&
                isSameTree(p.right,q.right);
    }
}
