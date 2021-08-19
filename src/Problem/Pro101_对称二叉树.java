package Problem;

import helper.TreeNode;

import java.util.*;

public class Pro101_对称二叉树 {

    public static void main(String[] args) {
        // [1,2,2,3,4,4,3]
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)));

        System.out.println(new Pro101_对称二叉树().isSymmetric(root));
    }

    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     */
    // 迭代解法
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                return false;
            }

            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }
            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }

        return true;
    }

    // 递归解法
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        return check(root.left, root.right);
//    }
//
//    // 两个树是否是镜像对称的
//    public boolean check(TreeNode node1, TreeNode node2) {
//        if (node1 == node2) {
//            return true;
//        }
//        if (node1 == null || node2 == null) {
//            return false;
//        }
//        return node1.val == node2.val && check(node1.left, node2.right) && check(node1.right, node2.left);
//    }
}
