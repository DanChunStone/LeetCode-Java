package Problem;

import helper.TreeNode;

public class Pro098_验证二叉搜索树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(6))), new TreeNode(5, new TreeNode(4), new TreeNode(6)));
        System.out.println(new Pro098_验证二叉搜索树().isValidBST(root));
    }

    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     * 假设一个二叉搜索树具有如下特征：
     * <p>
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     */
    public boolean isValidBST(TreeNode root) {
        int[] temp = new int[2];
        return isValidBST(root, temp);
    }

    public boolean isValidBST(TreeNode root, int[] temp) {
        if (root == null) {
            return true;
        }

        int min = root.val, max = root.val;

        boolean result = true;
        if (root.left != null) {
            result = isValidBST(root.left, temp);
            result &= temp[1] < root.val;
            min = Math.min(min, Math.min(temp[0], temp[1]));
//            max = Math.max(max, Math.max(temp[0], temp[1]));
        }
        if (root.right != null && result) {
            result = isValidBST(root.right, temp);
            result &= temp[0] > root.val;
//            min = Math.min(min, Math.min(temp[0], temp[1]));
            max = Math.max(max, Math.max(temp[0], temp[1]));
        }
        temp[0] = min;
        temp[1] = max;
        return result;
    }
}
