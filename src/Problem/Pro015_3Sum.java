package Problem;

import java.util.*;

/**
 * @author danchun
 * @date 2021/3/29 19:48
 */
public class Pro015_3Sum {

    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}).toString());
        System.out.println(new Solution().threeSum(new int[]{}).toString());
        System.out.println(new Solution().threeSum(new int[]{0, 0, 0, 0}).toString());
    }

    /**
     * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
     * Find all unique triplets in the array which gives the sum of zero.
     * <p>
     * Notice that the solution set must not contain duplicate triplets.
     * <p>
     * Example 1:
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     * <p>
     * Example 2:
     * Input: nums = []
     * Output: []
     * <p>
     * Example 3:
     * Input: nums = [0]
     * Output: []
     */
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null || nums.length < 3)
                return new ArrayList<>();

            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                if (i != 0 && nums[i - 1] == nums[i])
                    continue;
                int start = i + 1, end = nums.length - 1;
                while (start < end) {
                    int sum = nums[i] + nums[start] + nums[end];
                    if (sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        
                        while (start < end && nums[start + 1] == nums[start])
                            start++;
                        while (start < end && nums[end - 1] == nums[end])
                            end--;
                        start++;
                        end--;
                    } else if (sum > 0) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
            return result;
        }
    }
}
