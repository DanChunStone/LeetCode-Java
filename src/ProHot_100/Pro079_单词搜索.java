package ProHot_100;

import java.util.ArrayList;
import java.util.List;

public class Pro079_单词搜索 {

    public static void main(String[] args) {
        System.out.println(new Pro079_单词搜索().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println(new Pro079_单词搜索().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
        System.out.println(new Pro079_单词搜索().exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
    }

    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     * 同一个单元格内的字母不允许被重复使用。
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || board.length < 1 || board[0].length < 1 || word.length() == 0)
            return false;

        int m = board.length;
        int n = board[0].length;
        char[] chars = word.toCharArray();
        int[][] indexs = new int[m][n];

        List<int[]> points = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                indexs[i][j] = 0;
                if (board[i][j] == chars[0]) {
                    points.add(new int[]{i, j});
                }
            }
        }

        for (int[] point : points) {
            if (startFind(board, indexs, chars, 0, point[0], point[1])) {
                return true;
            }
        }
        return false;
    }

    private boolean startFind(char[][] board, int[][] temp, char[] chars, int index, int x, int y) {
        if (index >= chars.length) {
            return true;
        }
        char currentChar = chars[index];
        boolean legal = x >= 0 && x < board.length && y >= 0 && y < board[0].length
                && board[x][y] == currentChar && temp[x][y] == 0;
        if (!legal) {
            return false;
        }

        temp[x][y] = 1;
        boolean result = startFind(board, temp, chars, index + 1, x + 1, y)
                || startFind(board, temp, chars, index + 1, x, y + 1)
                || startFind(board, temp, chars, index + 1, x - 1, y)
                || startFind(board, temp, chars, index + 1, x, y - 1);
        temp[x][y] = 0;
        return result;
    }
}
