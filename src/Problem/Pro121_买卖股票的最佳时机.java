package Problem;

public class Pro121_买卖股票的最佳时机 {

    public static void main(String[] args) {
        System.out.println(new Pro121_买卖股票的最佳时机().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new Pro121_买卖股票的最佳时机().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int result = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            result = Math.max(result, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return result;
    }
}
