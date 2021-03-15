package Problem;

import helper.ProblemObject;

import java.util.Arrays;

/**
 * @author shilijun
 * @date 2020/11/26 9:14
 */
public class Pro164_MaximumGap extends ProblemObject {

    public static Pro164_MaximumGap instance = new Pro164_MaximumGap();

    public static void main(String[] args) {
        System.out.println(instance.maximumGap(new int[]{1, 3, 100}));
    }

    /**
     * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
     * 如果数组元素个数小于 2，则返回 0。
     * <p>
     * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
     * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
     * 复杂度：O(n)
     */
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        int gap = Math.max(1, (max - min) / (nums.length - 1));
        int bucketSize = (max - min) / gap + 1; // +1应该是保证桶的个数为[0, (max - min) / gap]

        int[] bucketMaxs = new int[bucketSize];
        int[] bucketMins = new int[bucketSize];
        for (int i = 0; i < bucketSize; i++) {
            bucketMaxs[i] = -1;
            bucketMins[i] = -1;
        }

        // 遍历，记录每个桶中最小值与最大值
        for (int num : nums) {
            int index = (num - min) / gap;
            bucketMaxs[index] = bucketMaxs[index] >= 0 ? Math.max(bucketMaxs[index], num) : num;
            bucketMins[index] = bucketMins[index] >= 0 ? Math.min(bucketMins[index], num) : num;
        }

        int maxGap = 0;
        int last = -1;
        for (int i = 0; i < bucketSize; i++) {
            if (bucketMaxs[i] == -1) {
                continue;
            }

            if (last >= 0) {
                maxGap = Math.max(maxGap, bucketMins[i] - bucketMaxs[last]);
            }
            last = i;
        }

        return maxGap;
    }
    
//    public int maximumGap(int[] nums) {
//        if (nums == null || nums.length < 2)
//            return 0;
//        
//        Arrays.sort(nums);
//        int maxGap = 0;
//        for (int i = 1; i < nums.length; i++) {
//            maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
//        }
//        
//        return maxGap;
//    }
}
