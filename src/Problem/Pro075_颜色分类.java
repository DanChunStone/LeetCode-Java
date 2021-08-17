package Problem;

import java.util.Arrays;

public class Pro075_颜色分类 {

    public static void main(String[] args) {
        int[] colors1 = new int[]{2, 0, 2, 1, 1, 0};
        new Pro075_颜色分类().sortColors(colors1);
        System.out.println(Arrays.toString(colors1));

        colors1 = new int[]{2, 0, 1};
        new Pro075_颜色分类().sortColors(colors1);
        System.out.println(Arrays.toString(colors1));

        colors1 = new int[]{0};
        new Pro075_颜色分类().sortColors(colors1);
        System.out.println(Arrays.toString(colors1));

        colors1 = new int[]{1};
        new Pro075_颜色分类().sortColors(colors1);
        System.out.println(Arrays.toString(colors1));
    }

    /**
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int left = 0, right = nums.length - 1;
        int current = 0;

        while (left < right && nums[left] == 0) {
            left++;
        }
        while (left < right && nums[right] == 2) {
            right--;
        }
        while (left < right && current <= right) {
            current = Math.max(left, current);
            if (nums[current] == 0) {
                int temp = nums[left];
                nums[left] = nums[current];
                nums[current] = temp;
            } else if (nums[current] == 2) {
                int temp = nums[right];
                nums[right] = nums[current];
                nums[current] = temp;
            } else {
                current++;
            }
            while (left < right && nums[left] == 0) {
                left++;
            }
            while (left < right && nums[right] == 2) {
                right--;
            }
        }
    }
}
