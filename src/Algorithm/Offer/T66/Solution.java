package Algorithm.Offer.T66;

/**
 * 机器人的运动范围
 * <p>
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * @author: wangfei
 * @date: 2019/5/16 14:06
 */
public class Solution {

    public static int movingCount(int threshold, int rows, int cols) {
        //记录是否已经走过
        int flag[][] = new int[rows][cols];
        return helper(0, 0, rows, cols, flag, threshold);
    }

    private static int helper(int i, int j, int rows, int cols, int[][] flag, int threshold) {
        //递归终止条件
        if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j) > threshold || flag[i][j] == 1)
            return 0;
        //要走的位置为 1，表示已经走过了
        flag[i][j] = 1;
        return helper(i - 1, j, rows, cols, flag, threshold)
                + helper(i + 1, j, rows, cols, flag, threshold)
                + helper(i, j - 1, rows, cols, flag, threshold)
                + helper(i, j + 1, rows, cols, flag, threshold)
                + 1;
    }

    private static int numSum(int i) {
        int sum = 0;
        do {
            sum += i % 10;
        } while ((i = i / 10) > 0);
        return sum;
    }
}
