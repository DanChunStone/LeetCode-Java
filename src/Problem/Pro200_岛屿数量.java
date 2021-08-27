package Problem;

import java.util.Deque;
import java.util.LinkedList;

public class Pro200_岛屿数量 {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        char[][] grid1 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(new Pro200_岛屿数量().numIslands(grid));
        System.out.println(new Pro200_岛屿数量().numIslands(grid1));
    }

    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * 此外，你可以假设该网格的四条边均被水包围。
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        int lands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    lands++;
                    Deque<Integer> deque = new LinkedList<>();
                    deque.add(i * n + j);
                    while (!deque.isEmpty()) {
                        int index = deque.remove();
                        int x = index / n;
                        int y = index % n;
                        grid[x][y] = '0';

                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            deque.add((x - 1) * n + y);
                            grid[x - 1][y] = '0';
                        }
                        if (x + 1 < m && grid[x + 1][y] == '1') {
                            deque.add((x + 1) * n + y);
                            grid[x + 1][y] = '0';
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            deque.add(x * n + y - 1);
                            grid[x][y - 1] = '0';
                        }
                        if (y + 1 < n && grid[x][y + 1] == '1') {
                            deque.add(x * n + y + 1);
                            grid[x][y + 1] = '0';
                        }
                    }
                }
            }
        }
        return lands;
    }


}
