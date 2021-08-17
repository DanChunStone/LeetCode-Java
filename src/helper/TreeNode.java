package helper;

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
}
