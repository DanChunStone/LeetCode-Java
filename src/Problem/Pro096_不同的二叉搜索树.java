package Problem;

public class Pro096_不同的二叉搜索树 {

    public static void main(String[] args) {
//        System.out.println(new Pro096_不同的二叉搜索树().numTrees(1));
//        System.out.println(new Pro096_不同的二叉搜索树().numTrees(2));
        System.out.println(new Pro096_不同的二叉搜索树().numTrees(3)); // 5
        System.out.println(new Pro096_不同的二叉搜索树().numTrees(19)); //
    }

    /**
     * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
     */
    public int numTrees(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }

        int[] temp = new int[n + 1];
        temp[0] = 1;
        temp[1] = 1;
        temp[2] = 2;

        for (int i = 2; i <= n; i++) {
            temp[i] = 0;
            for (int j = 0; j < i; j++) {
                temp[i] += temp[j] * temp[i - j - 1];
            }
        }
        return temp[n];
    }
}
