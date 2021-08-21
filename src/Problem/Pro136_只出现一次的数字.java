package Problem;

public class Pro136_只出现一次的数字 {

    public static void main(String[] args) {
        System.out.println(new Pro136_只出现一次的数字().singleNumber(new int[]{2, 2, 1}));
        System.out.println(new Pro136_只出现一次的数字().singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     */
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }

        return result;
    }
}
