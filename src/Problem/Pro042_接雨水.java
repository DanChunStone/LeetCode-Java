package Problem;

public class Pro042_接雨水 {

    public static void main(String[] args) {
        System.out.println(new Pro042_接雨水().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(new Pro042_接雨水().trap(new int[]{4, 2, 0, 3, 2, 5}));
    }

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int length = height.length;
        int[] leftHeight = new int[length];
        int[] rightHeight = new int[length];

        int current = 0;
        for (int i = 0; i < length; i++) {
            leftHeight[i] = Math.max(0, current - height[i]);
            current = Math.max(current, height[i]);
        }

        int result = 0;
        current = 0;
        for (int i = length - 1; i >= 0; i--) {
            rightHeight[i] = Math.max(0, current - height[i]);
            current = Math.max(current, height[i]);
            result += Math.min(leftHeight[i], rightHeight[i]);
        }
        return result;
    }
}
