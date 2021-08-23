package Problem;

public class Pro152_乘积最大子数组 {

    public static void main(String[] args) {
        System.out.println(new Pro152_乘积最大子数组().maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(new Pro152_乘积最大子数组().maxProduct(new int[]{-2, 0, -1}));
        System.out.println(new Pro152_乘积最大子数组().maxProduct(new int[]{-2, 3, -4}));
    }

    /**
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max, min;
        max = min = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int lastMax = max;
            int lastMin = min;
            max = nums[i] > 0 ? Math.max(nums[i], lastMax * nums[i]) : Math.max(nums[i], lastMin * nums[i]);
            min = nums[i] > 0 ? Math.min(nums[i], lastMin * nums[i]) : Math.min(nums[i], lastMax * nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }
}
