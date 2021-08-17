package Problem;

import java.util.Arrays;

public class Pro016_3SumClosest {
    public static void main(String[] args) {
        System.out.println(new Solution().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            if (nums == null || nums.length < 3)
                return 0;

            Arrays.sort(nums);
            int result = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1])
                    continue;
                int p = i + 1, q = nums.length - 1;
                while (p < q) {
                    int sum = nums[i] + nums[p] + nums[q];
                    if (Math.abs(target - result) > Math.abs(target - sum))
                        result = sum;

                    if (sum > target)
                        q--;
                    else if (sum < target)
                        p++;
                    else
                        return result;
                }
            }
            return result;
        }
    }
}
