package Problem;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Pro114_二叉树展开为链表 {

    public static void main(String[] args) {

    }

    /**
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     * <p>
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> list = new LinkedList<>();
        flatten(root, list);
        if (!list.isEmpty()) {
            root = list.poll();
        }
        while (!list.isEmpty()) {
            root.right = list.poll();
            root.left = null;
            root = root.right;
        }
    }

    public void flatten(TreeNode root, Deque<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        if (root.left != null) {
            flatten(root.left, list);
        }
        if (root.right != null) {
            flatten(root.right, list);
        }
    }
}
