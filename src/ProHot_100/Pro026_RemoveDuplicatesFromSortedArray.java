package ProHot_100;

import java.util.Arrays;

public class Pro026_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int length = new Solution().removeDuplicates(nums);

        System.out.println(length);
        System.out.println(Arrays.toString(nums));
    }

    static class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null)
                return 0;
            if (nums.length <= 1)
                return 1;

            int start = 0;
            int size = 0;
            int current = Integer.MIN_VALUE;
            while (start + size < nums.length) {
                if (nums[start] > current) {
                    current = nums[start];
                    start++;
                } else { // 遇到重复
                    while (start + size < nums.length && nums[start + size] <= current) {
                        size++;
                    }
                    if (start + size < nums.length) {
                        int temp = nums[start];
                        nums[start] = nums[start + size];
                        nums[start + size] = temp;
                        current = nums[start];
                        start++;
                    }
                }
            }

            return start;
        }
    }
}
