package Algorithm.LeetCode.T64;

/**
 * 最小和路径
 * <p>
 * 给定一个m x n的非负数网格，找到一条从左上角到右下角的路径，使其路径上所有数字的和最小化。
 * 注意:您只能在任何时间点向下或向右移动。
 *
 * @author: wangfei
 * @date: 2019/6/3 17:07
 */
public class Solution {

    /**
     * 动态规划
     * 1、左上角和右下角元素一定会加上
     * 2、当前元素的右邻元素最短路径与下邻元素最短路径求最小值
     * 3、以此类推求出最短路径
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        return pathSum(grid, 0, 0, memo);
    }

    private static int pathSum(int[][] grid, int row, int col, int[][] memo) {
        //右下角元素
        if (row == grid.length - 1 && col == grid[0].length - 1)
            return grid[row][col];
        if (memo[row][col] != 0)
            return memo[row][col];
        int rowInc = Integer.MAX_VALUE, colInc = Integer.MAX_VALUE;
        if (row < grid.length - 1)
            rowInc = pathSum(grid, row + 1, col, memo);
        if (col < grid[0].length - 1)
            colInc = pathSum(grid, row, col + 1, memo);
        memo[row][col] = Math.min(rowInc, colInc) + grid[row][col];
        return memo[row][col];
    }

    public static int minPathSum2(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[j] = dp[j];
                } else if (i == 0) {
                    dp[j] = dp[j - 1];
                } else {
                    dp[i] = Math.min(dp[j], dp[j - 1]);
                }
                dp[j] += grid[i][j];
            }
        }
        return dp[n - 1];
    }
    
    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
