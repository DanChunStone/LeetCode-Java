package Problem;


import helper.TreeNode;

/**
 * @author shilijun
 * @date 2020/11/24 9:55
 */
public class Pro222_CountCompleteTreeNodes {
    public static void main(String[] args) {

    }

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = calculateDepth(root.left);
        int rightDepth = calculateDepth(root.right);

        if (leftDepth == rightDepth) {
            return (1 << leftDepth)  + countNodes(root.right);
        } else {
            return (1 << rightDepth) + countNodes(root.left);
        }
    }

    public int calculateDepth(TreeNode treeNode) {
        int depth = 0;
        while (treeNode != null) {
            treeNode = treeNode.left;
            depth++;
        }
        return depth;
    }

    /**
     * 自己版本
     */
//    public int countNodes(TreeNode root) {
//        if (root == null)
//            return 0;
//        return countNodes(root.left) + countNodes(root.right) + 1;
//    }
}
