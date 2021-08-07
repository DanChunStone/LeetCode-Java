package ProHot_100;

import java.util.Arrays;

/**
 * @author shilijun
 * @date 2020/12/1 11:56
 */
public class Pro034_FindFirstAndLastPosition {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Pro034_FindFirstAndLastPosition().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(new Pro034_FindFirstAndLastPosition().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(new Pro034_FindFirstAndLastPosition().searchRange(new int[]{}, 0)));
    }

    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     * <p>
     * 进阶：
     * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
     */
//    public int[] searchRange(int[] nums, int target) {
//        if (nums == null || nums.length == 0)
//            return new int[]{-1, -1};
//
//        int[] result = new int[]{-1, -1};
//
//        int targetIndex = binarySearch(nums, 0, nums.length - 1, target);
//        result[0] = result[1] = targetIndex;
//
//        if (targetIndex >= 0) {
//            while (result[0] >= 0 && nums[result[0]] == target) {
//                result[0]--;
//            }
//            while (result[1] < nums.length && nums[result[1]] == target) {
//                result[1]++;
//            }
//            result[0]++;
//            result[1]--;
//        }
//
//        return result;
//    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        if (start >= end) {
            return nums[start] == target ? start : -1;
        }
        if (end - start == 1) {
            if (nums[start] == target)
                return start;
            else if (nums[end] == target)
                return end;
            else
                return -1;
        }
        int center = (start + end) / 2;
        if (nums[center] > target) {
            return binarySearch(nums, start, center - 1, target);
        } else if (nums[center] < target) {
            return binarySearch(nums, center + 1, end, target);
        } else {
            return center;
        }
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};

        int[] result = new int[]{-1, -1};

        int start = binarySearchStart(nums, 0, nums.length - 1, target);
        int end = binarySearchEnd(nums, 0, nums.length - 1, target);
        result[0] = start;
        result[1] = end;

        return result;
    }

    private int binarySearchStart(int[] nums, int start, int end, int target) {
        if (start >= end) {
            return nums[start] == target ? start : -1;
        }
        if (end - start == 1) {
            if (nums[start] == target)
                return start;
            else if (nums[end] == target)
                return end;
            else
                return -1;
        }
        int center = (start + end) / 2;
        if (nums[center] >= target) {
            return binarySearchStart(nums, start, center, target);
        } else {
            return binarySearchStart(nums, center + 1, end, target);
        }
    }

    private int binarySearchEnd(int[] nums, int start, int end, int target) {
        if (start >= end) {
            return nums[start] == target ? start : -1;
        }
        if (end - start == 1) {
            if (nums[end] == target)
                return end;
            else if (nums[start] == target)
                return start;
            else
                return -1;
        }
        int center = (start + end) / 2;
        if (nums[center] > target) {
            return binarySearchEnd(nums, start, center - 1, target);
        } else {
            return binarySearchEnd(nums, center, end, target);
        }
    }
}
