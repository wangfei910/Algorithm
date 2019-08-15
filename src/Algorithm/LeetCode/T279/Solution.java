package Algorithm.LeetCode.T279;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 完全平方
 * <p>
 * 给定一个正整数n，找出与n求和的最小的完全平方数(例如，1、4、9、16、…)。
 *
 * @author: wangfei
 * @date: 2019/6/6 8:25
 */
public class Solution {

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
            }
        }
        return dp[n];
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public static int numSquares2(int n) {
        int[] res = new int[n + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                res[i] = Math.min(res[i], res[i - j * j] + 1);
            }
        }
        return res[n];
    }

    /**
     * BFS
     *
     * @param n
     * @return
     */
    public static int numSquares3(int n) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(n);
        int depth = 1, m = 1, tmp = 0;
        while (true) {
            if (m == 0) {
                depth++;
                m = tmp;
                tmp = 0;
            }
            int cur = queue.remove();
            m--;
            int l = (int) Math.sqrt(cur);
            for (int i = l; i > 0; i--) {
                int sq = i * i;
                int delta = cur - sq;
                if (delta == 0)
                    return depth;
                queue.add(delta);
                tmp++;
            }
        }
    }

    public static int numSquares4(int n) {
        if (n < 1)
            return 0;
        return squares(n, (int) Math.sqrt(n), 1, Integer.MAX_VALUE);
    }

    private static int squares(int n, int root, int count, int sqmin) {

        if (count >= sqmin) {
            return sqmin;
        }
        int min = 0;
        for (; root > 0; root--) {
            int sqr = (root * root);
            if (n < sqr) {
                continue;
            } else if (n % sqr == 0) {
                min = count + ((n / sqr) - 1);
            } else {
                min = squares(n - sqr, root, count + 1, sqmin);
            }
            if (min < sqmin) {
                sqmin = min;
            }
        }
        return sqmin;
    }


    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int n = 12;
        System.out.println(numSquares2(n));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
