package Algorithm.LeetCode.T122;

public class Solution {
    /**
     * 只要第二天的股价比当天的高，那就在当天买进，第二天卖出，这样利润最大
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1])
                profit = profit + prices[i + 1] - prices[i];
        }
        return profit;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] price = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(price));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
