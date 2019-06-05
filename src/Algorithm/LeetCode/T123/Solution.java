package Algorithm.LeetCode.T123;

/**
 * @author: wangfei
 * @date: 2019/4/21 16:02
 */
public class Solution {

    public static int maxProfit(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;
        for (int curPrice : prices) {
            if (firstBuy < -curPrice) {
                firstBuy = -curPrice;
            }
            if (firstSell < firstBuy + curPrice) {
                firstSell = firstBuy + curPrice;
            }
            if (secondBuy < firstSell - curPrice) {
                secondBuy = firstSell - curPrice;
            }
            if (secondSell < secondBuy + curPrice) {
                secondSell = secondBuy + curPrice;
            }
        }
        return secondSell;
    }

    public static int maxProfit1(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        //假设我们一开始只有0美元
        int release1 = 0, release2 = 0;
        for (int curPrice : prices){
            //如果我们到目前为止只卖出了第二支股票，就会达到最大值
            release2 = Math.max(release2, hold2 + curPrice);
            //到目前为止我们只买了第二支股票
            hold2 = Math.max(hold2, release1 - curPrice);
            //到目前为止，如果我们刚刚卖出第1只股票，就会达到最大值
            release1 = Math.max(release1, hold1 + curPrice);
            //到目前为止我们只买了1支股票
            hold1 = Math.max(hold1, -curPrice);
        }
        //因为release1的初始值为0，所以release2将始终高于release1
        return release2;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(prices));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
