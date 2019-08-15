package Algorithm.LeetCode.T62;

/**
 * 独特的路径
 * <p>
 * 机器人位于m*n网格的左上角(下图中标记为“Start”)。
 * 机器人只能在任何时间点向下或向右移动。机器人正试图到达网格的右下角(下图中标记为“Finish”)。
 * 有多少种可能的唯一路径?
 *
 * @author: wangfei
 * @date: 2019/6/6 8:41
 */
public class Solution {

    /**
     * 动态规划
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePath(int m, int n) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
                }
            }
        }
        return grid[m - 1][n - 1];
    }

    public static int uniquePath2(int m, int n) {
        int smaller = m > n ? n - 1 : m - 1;
        int totalSteps = m + n - 2;
        long res = 1;
        for (int count = 1; count <= smaller; count++) {
            res *= totalSteps--;
            res /= count;
        }
        return (int) res;
    }

    public static int uniquePaths3(int m, int n) {
        int[] dp = new int[m];
        dp[0] = 1;
        for (int i = 0; i < n; i++)
            for (int j = 1; j < m; j++)
                dp[j] = dp[j - 1] + dp[j];
        return dp[m - 1];
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int m = 3;
        int n = 2;
        System.out.println(uniquePath2(m, n));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
