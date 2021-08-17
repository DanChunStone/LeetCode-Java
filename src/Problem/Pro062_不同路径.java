package Problem;

public class Pro062_不同路径 {

    public static void main(String[] args) {
        System.out.println(new Pro062_不同路径().uniquePaths(3, 7));
        System.out.println(new Pro062_不同路径().uniquePaths(3, 2));
        System.out.println(new Pro062_不同路径().uniquePaths(7, 3));
        System.out.println(new Pro062_不同路径().uniquePaths(3, 3));
        System.out.println(new Pro062_不同路径().uniquePaths(51, 9));
    }

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     * 问总共有多少条不同的路径？
     */
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            temp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            temp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                temp[i][j] = temp[i - 1][j] + temp[i][j - 1];
            }
        }
        return temp[m - 1][n - 1];
    }
}
