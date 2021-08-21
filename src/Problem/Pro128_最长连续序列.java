package Problem;

import java.util.HashSet;
import java.util.Set;

public class Pro128_最长连续序列 {

    public static void main(String[] args) {
        System.out.println(new Pro128_最长连续序列().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(new Pro128_最长连续序列().longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int result = 1;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int temp = 1;
                while (set.contains(++n)) {
                    temp++;
                }
                result = Math.max(result, temp);
            }
        }
        return result;
    }
}
