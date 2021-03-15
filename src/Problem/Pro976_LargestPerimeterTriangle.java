package Problem;

import java.util.Arrays;

public class Pro976_LargestPerimeterTriangle {

    public static void main(String[] args) {
        
    }

    /**
     * 三角形任意两边之和大于第三边
     * 排序后倒序取最大值为最长边
     * 则其前两个数即为和最可能大于最长边的两边
     */
    public int largestPerimeter(int[] A) {
        if (A.length < 3)
            return 0;

        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i - 1] + A[i - 2] > A[i]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }
}
