package Problem;

public class Pro198_打家劫舍 {

    public static void main(String[] args) {
        System.out.println(new Pro198_打家劫舍().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new Pro198_打家劫舍().rob(new int[]{2, 7, 9, 3, 1}));
    }

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] money = new int[nums.length];
        money[0] = nums[0];
        int maxMoney = money[0];

        for (int i = 1; i < nums.length; i++) {
            money[i] = Math.max(nums[i],
                    Math.max(nums[i] + (i - 2 >= 0 ? money[i - 2] : Integer.MIN_VALUE),
                            nums[i] + (i - 3 >= 0 ? money[i - 3] : Integer.MIN_VALUE)));
            maxMoney = Math.max(maxMoney, money[i]);
        }

        return maxMoney;
    }
}
