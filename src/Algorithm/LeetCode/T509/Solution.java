package Algorithm.LeetCode.T509;

/**
 * 菲波那切数列
 * <p>
 * 斐波那契数列，通常表示F(n)组成一个序列，称为斐波那契数列，这样每个数字都是前两个数列的和，从0和1开始。也就是说,
 * F(0) = 0, F(1) = 1
 * F(N) = F(N - 1) + F(N - 2)对于N > 1。
 * 给定N，计算F(N)
 *
 * @author: wangfei
 * @date: 2019/6/6 9:08
 */
public class Solution {

    /**
     * DP
     *
     * @param N
     * @return
     */
    public static int fib(int N) {
        if (N < 1)
            return 0;
        int[] memo = new int[N + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= N; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[N];
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int N = 5;
        System.out.println(fib(N));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
