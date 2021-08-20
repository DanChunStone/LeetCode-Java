package helper;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shilijun
 * @date 2020/11/24 9:56
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

//    public static TreeNode build(int[] values) {
//        if (values.length <= 0)
//            return null;
//
//        int index = 0;
//        TreeNode head = new TreeNode(values[index++]);
//        TreeNode temp = head;
//
//        while (index < values.length) {
//            temp.next = new ListNode(values[index]);
//            temp = temp.next;
//            index++;
//        }
//        return head;
//    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(this);
        while (!deque.isEmpty()) {
            TreeNode treeNode = deque.poll();
            stringBuilder.append(treeNode.val).append(" ");
            if (treeNode.left != null) {
                deque.add(treeNode.left);
            }
            if (treeNode.right != null) {
                deque.add(treeNode.right);
            }
        }

        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
