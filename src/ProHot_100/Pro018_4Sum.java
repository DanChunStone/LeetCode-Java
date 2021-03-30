package ProHot_100;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pro018_4Sum {
    public static void main(String[] args) {
//        System.out.println(new Solution().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
//        System.out.println(new Solution().fourSum(new int[]{0, 0, 0, 0}, 1));
        System.out.println(new Solution().fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0));
    }

    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            if (nums == null || nums.length < 4)
                return new ArrayList<>();

            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1])
                    continue;
                if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                    break;

                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1])
                        continue;

                    int p = j + 1, q = nums.length - 1;
                    while (p < q) {
                        int sum = nums[i] + nums[j] + nums[p] + nums[q];
                        if (sum > target) {
                            q--;
                        } else if (sum < target) {
                            p++;
                        } else {
                            result.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
                            while (p < q && nums[p] == nums[p + 1])
                                p++;
                            p++;
                            while (p < q && nums[q] == nums[q - 1])
                                q--;
                            q--;
                        }
                    }
                }
            }
            return result;
        }
    }
}
