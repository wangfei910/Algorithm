package Algorithm.Test.Factorial;

/**
 * 斐波那契数列
 *
 * @author: wangfei
 * @date: 2019/5/16 20:02
 */
public class Solution {

    /**
     * 递归
     *
     * @param n
     * @return
     */
    public static int Factorial(int n) {
        if (n == 1 || n == 2)
            return 1;
        return Factorial(n - 1) + Factorial(n - 2);
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public static int Factorial2(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int n = 11;
        System.out.println(Factorial(n));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
