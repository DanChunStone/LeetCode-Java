package Problem;

import helper.ListNode;
import helper.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Pro094_二叉树的中序遍历 {

    public static void main(String[] args) {
        System.out.println(new Pro094_二叉树的中序遍历().inorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))));
        System.out.println(new Pro094_二叉树的中序遍历().inorderTraversal(null));
        System.out.println(new Pro094_二叉树的中序遍历().inorderTraversal(new TreeNode(1)));
        System.out.println(new Pro094_二叉树的中序遍历().inorderTraversal(new TreeNode(1, new TreeNode(2), null)));
        System.out.println(new Pro094_二叉树的中序遍历().inorderTraversal(new TreeNode(1, null, new TreeNode(2))));
    }

    /**
     * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
     */
    public List<Integer> inorderTraversal(TreeNode root) { // 迭代的方式
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }

        return result;
    }

    // 递归的方式
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        inorderTraversal(root, result);
//        return result;
//    }
//
//    public void inorderTraversal(TreeNode root, List<Integer> result) {
//        if (root == null) {
//            return;
//        }
//        if (root.left != null) {
//            inorderTraversal(root.left, result);
//        }
//        result.add(root.val);
//        if (root.right != null) {
//            inorderTraversal(root.right, result);
//        }
//    }
}
