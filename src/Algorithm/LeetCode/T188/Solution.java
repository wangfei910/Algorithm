package Algorithm.LeetCode.T188;

/**
 * 股票买卖的最佳时机(只能交易K次)
 *
 * @author: wangfei
 * @date: 2019/4/21 11:29
 */
public class Solution {
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        //这种情况下该问题退化为普通的股票交易问题
        if (k >= n / 2) {
            int maxProfit = 0;
            for (int i = 0; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }
        int[][] maxProfit = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int localMax = maxProfit[i - 1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                maxProfit[i][j] = Math.max(maxProfit[i][j - 1], prices[j] + localMax);
                localMax = Math.max(localMax, maxProfit[i - 1][j] - prices[j]);
            }
        }
        return maxProfit[k][n - 1];
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        int k = 2;
        int[] prices = {2, 4, 1};
        System.out.println(maxProfit(k, prices));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
