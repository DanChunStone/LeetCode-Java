package Problem;

import java.util.HashMap;

/**
 * @author shilijun
 * @date 2020/11/27 19:06
 */
public class Pro454_4SumII {
    public static void main(String[] args) {
        System.out.println();
    }

    /**
     * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) 
     * there are such that A[i] + B[j] + C[k] + D[l] is zero.
     *
     * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. 
     * All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int length = A.length;

        int count = 0;
        HashMap<Integer, Integer> mapAB = new HashMap<>(length * length);
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                Integer num = mapAB.get(sum);
                mapAB.put(sum, num == null ? 1 : num + 1);
            }
        }
        for (int c : C) {
            for (int d : D) {
                int sum = -(c + d);
                Integer num = mapAB.get(sum);
                if (num != null)
                    count += num;
            }
        }
        return count;
    }
}
