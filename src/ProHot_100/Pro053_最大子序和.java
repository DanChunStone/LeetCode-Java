package ProHot_100;

public class Pro053_最大子序和 {

    public static void main(String[] args) {
//        System.out.println(new Pro053_最大子序和().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
//        System.out.println(new Pro053_最大子序和().maxSubArray(new int[]{1}));
//        System.out.println(new Pro053_最大子序和().maxSubArray(new int[]{0}));
//        System.out.println(new Pro053_最大子序和().maxSubArray(new int[]{-1}));
//        System.out.println(new Pro053_最大子序和().maxSubArray(new int[]{-100000}));
        System.out.println(new Pro053_最大子序和().maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int n = nums.length;
        int result = nums[0];
        int[] step = new int[n];
        step[0] = nums[0];

        for (int i = 1; i < n; i++) {
            int preStep = step[i - 1];
            if (preStep > 0) {
                step[i] = preStep + nums[i];
            } else {
                step[i] = nums[i];
            }
            result = Math.max(result, step[i]);
        }
        return result;
    }
}
