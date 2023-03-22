package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N 叉树的前序遍历
 */
public class NTreePreorder {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        helper(root,result);
        return result;
    }

    private void helper(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        for (Node node : root.children) {
            helper(node,result);
        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
