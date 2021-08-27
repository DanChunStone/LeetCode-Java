package Problem;

public class Pro169_多数元素 {

    public static void main(String[] args) {
        System.out.println(new Pro169_多数元素().majorityElement(new int[]{3, 2, 3}));
        System.out.println(new Pro169_多数元素().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int number = nums[0];
        int length = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == number) {
                length++;
            } else {
                length--;
            }
            if (length == -1) {
                number = nums[i];
                length = 0;
            }
        }
        return number;
    }
}
