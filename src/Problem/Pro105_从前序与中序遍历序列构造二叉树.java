package Problem;

import helper.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Pro105_从前序与中序遍历序列构造二叉树 {

    public static void main(String[] args) {
        System.out.println(new Pro105_从前序与中序遍历序列构造二叉树().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }

    /**
     * 给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。
     */
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        map.clear();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int start, int end, int[] inorder, int start2, int end2) {
        if (start == end) {
            return new TreeNode(preorder[start]);
        }

        int current = preorder[start];
        int inorderIndex = map.get(current);
        TreeNode treeNode = new TreeNode(current);
        if (inorderIndex - start2 > 0) {
            treeNode.left = buildTree(preorder, start + 1, start + (inorderIndex - start2), inorder, start2, inorderIndex - 1);
        }
        if (end2 - inorderIndex > 0) {
            treeNode.right = buildTree(preorder, start + (inorderIndex - start2) + 1, end, inorder, inorderIndex + 1, end2);
        }
        return treeNode;
    }
}
