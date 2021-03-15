package ProHot_100;

import java.util.HashMap;

public class Pro001_TwoSum {
    public static void main(String[] args) {

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
