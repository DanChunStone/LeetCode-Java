package ProHot_100;

public class Pro042_TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(new Pro042_TrappingRainWater().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(new Pro042_TrappingRainWater().trap(new int[]{4, 2, 0, 3, 2, 5}));
    }

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * <p>
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     */
    public int trap(int[] height) {
        if (height == null || height.length <= 2)
            return 0;

        int length = height.length;
        int size = length;
        int result = 0;

        int max = height[0];
        for (int value : height) {
            max = Math.max(max, value);
        }

        int level = 1;
        while (size > 1 && level <= max) { // 遍历每一层
            size = 0;

            boolean hasStart = false;
            int water = 0;
            for (int i = 0; i < length; i++) {
                if (height[i] >= level) {
                    hasStart = true;
                    result += water;
                    water = 0;
                    size++;
                } else {
                    water += hasStart ? 1 : 0;
                }
            }
            level++;
        }
        return result;
    }
}
