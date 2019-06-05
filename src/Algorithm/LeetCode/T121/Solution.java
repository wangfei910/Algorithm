package Algorithm.LeetCode.T121;

/**
 * 买卖股票（只允许交易一次）
 *
 * @author: wangfei
 * @date: 2019/4/21 16:35
 */
public class Solution {

    /**
     * 只要记录前面的最小价格，将这个最小价格作为买入价格，
     * 然后将当前的价格作为售出价格，查看当前收益是不是最大收益。
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int max = 0;
        int price1 = prices[0];
        for (int curPrice : prices) {
            //使price1为最小价格
            if (price1 > curPrice) {
                price1 = curPrice;
            }
            max = Math.max(curPrice - price1, max);
        }
        return max;
    }

    public static int maxProfit1(int[] prices) {
        int maxCur = 0, max = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
            max = Math.max(maxCur, max);
        }
        return max;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit1(prices));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
