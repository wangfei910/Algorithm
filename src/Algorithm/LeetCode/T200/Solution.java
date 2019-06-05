package Algorithm.LeetCode.T200;

/**
 * 岛的数目
 * <p>
 * 给定一个“1”(陆地)和“0”(水域)的二维网格地图，计算岛屿的数量。岛屿被水环绕，通过水平或垂直连接相邻的陆地而形成。
 * 你可以假设网格的四个边都被水包围着。
 *
 * @author: wangfei
 * @date: 2019/6/1 12:38
 */
public class Solution {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    DFS(grid, i, j);
                }
            }
        }
        return count;
    }

    private void DFS(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length)
            return;
        if (grid[i][j] == '1') {
            grid[i][j] = '2';
            DFS(grid, i + 1, j);
            DFS(grid, i - 1, j);
            DFS(grid, i, j + 1);
            DFS(grid, i, j - 1);
        }
    }
}
