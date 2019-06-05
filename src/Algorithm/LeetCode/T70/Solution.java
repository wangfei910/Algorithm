package Algorithm.LeetCode.T70;

/**
 * 爬楼梯
 *
 * @author: wangfei
 * @date: 2019/4/18 19:52
 */
public class Solution {

    public static int climbStairs(int n) {
        int a = 1, b = 1;
        while (n-- > 0) {
            b += a;
            a = b - a;
        }
        return a;
    }

    /**
     * 递推
     *
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    public static int climbStairs3(int n) {
        if (n <= 2) {
            return n;
        }
        int one_step_before = 2;
        int two_step_before = 1;
        int all_ways = 0;
        for (int i = 2; i < n; i++) {
            all_ways = one_step_before + two_step_before;
            two_step_before = one_step_before;
            one_step_before = all_ways;
        }
        return all_ways;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int n = 3;
        System.out.println(climbStairs2(n));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
