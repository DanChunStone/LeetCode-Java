package ProHot_100;

public class Pro064_最小路径和 {

    public static void main(String[] args) {
        System.out.println(new Pro064_最小路径和().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        System.out.println(new Pro064_最小路径和().minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }

    /**
     * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * 说明：每次只能向下或者向右移动一步。
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length <= 0 || grid[0].length <= 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] temp = new int[m][n];
        temp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            temp[i][0] = grid[i][0] + temp[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            temp[0][i] = grid[0][i] + temp[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                temp[i][j] = Math.min(temp[i - 1][j], temp[i][j - 1]) + grid[i][j];
            }
        }
        return temp[m - 1][n - 1];
    }
}
