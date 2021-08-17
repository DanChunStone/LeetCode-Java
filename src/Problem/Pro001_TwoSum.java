package Problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Pro001_TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length < 2)
                return null;

            int[] result = new int[]{0, 0};
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                Integer index = map.get(target - nums[i]);
                if (index != null) {
                    result[0] = index;
                    result[1] = i;
                    break;
                }
                map.put(nums[i], i);
            }
            return result;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;

            Integer index = map.get(complement);
            if (index != null) {
                return new int[]{index, i};
            }
            map.put(num, i);
        }
        return null;
    }
}
