package helper;

import java.util.Arrays;

public class Helper {

    public static String toString(int[][] value) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int[] i : value) {
            sb.append(Arrays.toString(i));
        }
        sb.append("]\n");
        return sb.toString();
    }
}
