package Algorithm.LeetCode.T152;

import java.util.Arrays;

/**
 * 乘积最大子序列
 *
 * @author: wangfei
 * @date: 2019/4/18 22:31
 */
public class Solution {

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[2][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 滚动数组，取值 0 or 1
            int x = i % 2;
            int y = (i - 1) % 2;
            dp[x][0] = Math.max(Math.max(dp[y][0] * nums[i], dp[y][1] * nums[i]), nums[i]);
            dp[x][1] = Math.min(Math.max(dp[y][0] * nums[i], dp[y][1] * nums[i]), nums[i]);
            res = Math.max(res, dp[x][0]);
        }
        return res;
    }

    /**
     * 暴力解法
     *
     * @param nums
     * @return
     */
    public static int maxProduct1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                // 复制的区间是左闭右开，即不包括j+1
                int[] subNums = Arrays.copyOfRange(nums, i, j + 1);
                int product = 1;
                for (int k = 0; k < subNums.length; k++) {
                    product *= subNums[k];
                }
                if (max < product)
                    max = product;
            }
        }
        return max;
    }


    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] nums = {4, 5, -8, 2};
        System.out.println(maxProduct1(nums));
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start) + "ms");
    }
}
