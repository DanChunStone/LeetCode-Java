package ProHot_100;

public class Pro055_跳跃游戏 {

    public static void main(String[] args) {
        System.out.println(new Pro055_跳跃游戏().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new Pro055_跳跃游戏().canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(new Pro055_跳跃游戏().canJump(new int[]{2, 0, 0}));
    }

    /**
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标。
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1)
            return true;

        int n = nums.length;
        int preStep = nums[0];
        if (preStep < 1) {
            return false;
        }

        for (int i = 1; i < n; i++) {
            preStep = Math.max(preStep - 1, nums[i]);
            if (preStep < 1 && i < n - 1) {
                return false;
            }
        }
        return true;
    }
}
