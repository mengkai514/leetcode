package BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class BuildTree105 {
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return findNode(inorder,0,inorder.length,preorder,0,preorder.length);
    }

    private TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] preorder, int preBegin, int preEnd) {
        // 参数里的范围都是前闭后开
        if (inBegin >= inEnd || preBegin >= preEnd) {  // 不满足左闭右开，说明没有元素，返回空树
            return null;
        }
        int rootIndex = map.get(preorder[preBegin]); //存的是root的index
        TreeNode root = new TreeNode(inorder[rootIndex]);
        int lenOfLeft = rootIndex - inBegin;  // 保存中序左子树个数，用来确定前序数列的个数
        root.left = findNode(inorder, inBegin, rootIndex, preorder, preBegin + 1,preBegin + lenOfLeft + 1);
        root.right = findNode(inorder, rootIndex + 1, inEnd, preorder, preBegin + lenOfLeft + 1, preEnd);
        return root;
    }
}
