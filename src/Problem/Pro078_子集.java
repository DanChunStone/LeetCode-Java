package Problem;

import helper.Helper;

import java.util.*;

public class Pro078_子集 {

    public static void main(String[] args) {
        System.out.println(Helper.toString(new Pro078_子集().subsets(new int[]{1, 2, 3})));
        System.out.println(Helper.toString(new Pro078_子集().subsets(new int[]{0})));
    }

    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        tempList.clear();

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            subsets(nums, result, i, 0);
        }
        return result;
    }

    private final List<Integer> tempList = new ArrayList<>();

    private void subsets(int[] nums, List<List<Integer>> result, int size, int start) {
        if (size == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        if (nums.length - start < size) {
            return;
        }

        int max = nums.length - size;
        for (int i = start; i <= max; i++) {
            tempList.add(nums[i]);
            subsets(nums, result, size - 1, i + 1);
            tempList.remove((Integer) nums[i]);
        }
    }
}
