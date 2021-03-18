package Problem;

import java.util.Arrays;

/**
 * @author shilijun
 * @date 2021/3/18 15:59
 */
public class Pro59_Spiral_Matrix_II {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Pro59_Spiral_Matrix_II().generateMatrix(3)));
    }

    public int[][] generateMatrix(int n) {
        if (n < 1)
            return null;

        int[][] result = new int[n][n];
        int number = 1;
        int layers = 0;

        while (number <= n * n) {
            for (int i = layers; i < n - layers; i++) // 0 - n
                result[layers][i] = number++;
            for (int i = layers + 1; i < n - layers; i++) // 1 - n
                result[i][n - layers - 1] = number++;
            for (int i = n - layers - 2; i >= layers; i--) // 0 - n - 1
                result[n - layers - 1][i] = number++;
            for (int i = n - layers - 2; i > layers; i--) // 1 - 
                result[i][layers] = number++;
            layers++;
        }
        return result;
    }
}
