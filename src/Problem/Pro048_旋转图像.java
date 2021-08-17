package Problem;

import java.util.Arrays;

public class Pro048_旋转图像 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Pro048_旋转图像().rotate(matrix);
        System.out.println(toString(matrix));

        matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        new Pro048_旋转图像().rotate(matrix);
        System.out.println(toString(matrix));

        matrix = new int[][]{{1}};
        new Pro048_旋转图像().rotate(matrix);
        System.out.println(toString(matrix));

        matrix = new int[][]{{1, 2}, {3, 4}};
        new Pro048_旋转图像().rotate(matrix);
        System.out.println(toString(matrix));
    }

    /**
     * 解法：
     * 1. 使用辅助矩阵，遍历保存到辅助矩阵中(禁止)
     * 2. 对于矩阵旋转90度，四个点可以构成一个替换循环，即左上角替换到右上角替换到右下角替换到左下角最后又替换到左上角；
     * 故，对于本题，即可遍历矩阵的左上四分之一个矩阵，循环替换即可。注意n的奇偶分开讨论。
     * 3. 对于矩阵旋转90度，可以被转换为：水平翻转后，再沿对角线进行一次翻转。
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length <= 1)
            return;

        int n = matrix.length;
        int rows = n / 2;
        int columns = n % 2 == 0 ? n / 2 : n / 2 + 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int row, column;
                int temp1, temp2;
                int x, y;


                row = i;
                column = j;
                x = column;
                y = n - 1 - row;
                temp1 = matrix[x][y];
                matrix[x][y] = matrix[row][column];

                row = x;
                column = y;
                x = column;
                y = n - 1 - row;
                temp2 = matrix[x][y];
                matrix[x][y] = temp1;
                temp1 = temp2;

                row = x;
                column = y;
                x = column;
                y = n - 1 - row;
                temp2 = matrix[x][y];
                matrix[x][y] = temp1;
                temp1 = temp2;

                row = x;
                column = y;
                x = column;
                y = n - 1 - row;
                matrix[x][y] = temp1;
            }
        }
    }

    private static String toString(int[][] value) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int[] i : value) {
            sb.append(Arrays.toString(i));
        }
        sb.append("]\n");
        return sb.toString();
    }
}
