package Algorithm.Offer.T7;

/**
 * 斐波那契数列
 *
 * @author wangfei
 */
public class Solution {
    /**
     * 循环
     *
     * @param n
     * @return
     */
    public static int Fibonacci(int n) {
        int x = 1, y = 0, res = 0;
        if (n <= 1)
            return n;
        for (int i = 2; i <= n; i++) {
            res = x + y;
            y = x;
            x = res;
        }
        return res;
    }

    /**
     * 递归
     *
     * @param n
     * @return
     */
    public static int Fibonacci2(int n) {
        if (n <= 1)
            return n;
        else
            return Fibonacci2(n - 1) + Fibonacci2(n - 2);
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int n = 30;
        System.out.println(Fibonacci(n));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
