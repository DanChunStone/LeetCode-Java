package helper;

import java.util.Arrays;
import java.util.List;

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

    public static String toString(List<List<Integer>> value) {
        StringBuilder sb = new StringBuilder();
        if (value == null) {
            return sb.append("null").toString();
        }
        sb.append("[");
        for (int i = 0; i < value.size(); i++) {
            List<Integer> list = value.get(i);
            if (list == null) {
                sb.append("null");
            } else {
                sb.append("[");
                for (int j = 0; j < list.size(); j++) {
                    sb.append(list.get(j));
                    if (j != list.size() - 1)
                        sb.append(", ");
                }
                sb.append("]");
            }
            if (i < value.size() - 1)
                sb.append(", ");
        }
        sb.append("]\n");
        return sb.toString();
    }
}
