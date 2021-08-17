package Problem;

import helper.Helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pro056_合并区间 {

    public static void main(String[] args) {
        System.out.println(Helper.toString(new Pro056_合并区间().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Helper.toString(new Pro056_合并区间().merge(new int[][]{{1, 4}, {4, 5}})));
        System.out.println(Helper.toString(new Pro056_合并区间().merge(new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}})));
        System.out.println(Helper.toString(new Pro056_合并区间().merge(new int[][]{{2, 3}, {4, 6}, {5, 7}, {3, 4}})));
    }

    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = new int[]{intervals[i][0], intervals[i][1]};

            Iterator<int[]> iterator = result.iterator();
            while (iterator.hasNext()) {
                int[] temp = iterator.next();
                int left = temp[0], right = temp[1];

                // start --- left --- end
                // left -- start -- right
                if ((interval[0] <= left && left <= interval[1]) || (left <= interval[0] && interval[0] <= right)) {
                    iterator.remove();
                    interval[0] = Math.min(left, interval[0]);
                    interval[1] = Math.max(right, interval[1]);
                }
            }
            result.add(interval);
        }
        int[][] resultArray = new int[result.size()][];
        result.toArray(resultArray);
        return resultArray;
    }
}
