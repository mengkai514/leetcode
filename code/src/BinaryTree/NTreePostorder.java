package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N 叉树的后序遍历
 */
public class NTreePostorder {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        helper(root,result);
        return result;
    }

    private void helper(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        for (Node node : root.children) {
            helper(node, result);
        }
        result.add(root.val);
    }
}
