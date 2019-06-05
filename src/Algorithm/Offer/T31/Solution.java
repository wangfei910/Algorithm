package Algorithm.Offer.T31;

/**
 * 整数中1出现的次数
 *
 * @author: wangfei
 * @date: 2019/5/5 21:33
 */
public class Solution {

    public static int NumberOfBetween1AndN(int n) {
        int count = 0;
        for (int m = 1; m <= n; m *= 10) {
            //取整
            int a = n / m;
            //取余
            int b = n % m;
            count += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return count;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int n = 0;
        System.out.println(NumberOfBetween1AndN(n));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
