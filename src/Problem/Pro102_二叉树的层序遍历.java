package Problem;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Pro102_二叉树的层序遍历 {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<List<Integer>> list = new Pro102_二叉树的层序遍历().levelOrder(head);
        for (List<Integer> l : list) {
            System.out.println(l.toString());
        }
    }

    /**
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        Deque<List<TreeNode>> nodeList = new LinkedList<>();
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        nodeList.add(nodes);

        while (!nodeList.isEmpty()) {
            List<TreeNode> list = nodeList.poll();
            List<TreeNode> newList = new ArrayList<>();
            List<Integer> data = new ArrayList<>();

            for (TreeNode treeNode : list) {
                data.add(treeNode.val);
                if (treeNode.left != null) newList.add(treeNode.left);
                if (treeNode.right != null) newList.add(treeNode.right);
            }

            if (!newList.isEmpty())
                nodeList.add(newList);
            result.add(data);
        }
        return result;
    }
}
