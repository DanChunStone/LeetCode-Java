package ProHot_100;

import java.util.Arrays;

public class Pro027_RemoveElement {

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,2};
        int val = 2;
        int length = new Pro027_RemoveElement().removeElement(nums, val);

        System.out.println(length);
        System.out.println(Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;

        int start = 0;
        int size = 0;
        while (start + size < nums.length) {
            if (nums[start] != val) {
                start++;
            } else { // 遇到目标值
                while (start + size < nums.length && nums[start + size] == val) {
                    size++;
                }
                if (start + size < nums.length) {
                    nums[start] = nums[start + size];
                    nums[start + size] = val;
                    start++;
                } else {
                    break;
                }
            }
        }
        return start;
    }
}
