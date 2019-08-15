package Algorithm.LeetCode.T416;

import java.util.Arrays;

/**
 * 分区等子集和
 * <p>
 * 给定一个只包含正整数的非空数组，找出该数组是否可以划分为两个子集，使两个子集中的元素之和相等。
 * 注意:
 * 每个数组元素都不超过100。
 * 数组大小不超过200。
 *
 * @author: wangfei
 * @date: 2019/6/19 12:57
 */
public class Solution {

    /**
     * 递归（记忆化搜索）
     *
     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0)
            return false;
        return tryPartition(nums, nums.length - 1, sum / 2);
    }

    //使用 nums[0...index], 是否可以完全填充一个容量为 sum 的背包
    private static boolean tryPartition(int[] nums, int index, int sum) {
        if (sum == 0)
            return true;
        if (sum < 0 || index < 0)
            return false;
        // memo[i][c] 表示使用索引为 [0...i] 的这些元素，是否可以完全填充一个容量为 c 的背包
        int[][] memo = new int[nums.length][sum + 1];
        if (memo[index][sum] != 0) {
            return memo[index][sum] == 1;
        }
        memo[index][sum] = (tryPartition(nums, index - 1, sum)
                || tryPartition(nums, index - 1, sum - nums[index])) ? 1 : 2;
        return memo[index][sum] == 1;
    }


    /**
     * DP
     *
     * @param nums
     * @return
     */
    public static boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0)
            return false;
        int n = nums.length;
        int C = sum / 2;
        boolean[] memo = new boolean[C + 1];
        Arrays.fill(memo, false);
        for (int i = 0; i <= C; i++) {
            memo[i] = (nums[0] == i);
        }
        for (int i = 1; i < n; i++) {
            for (int j = C; j >= nums[i]; j--) {
                memo[j] = memo[j] || memo[j - nums[i]];
            }
        }
        return memo[C];
    }

    /**
     * DP(最快)
     *
     * @param nums
     * @return
     */
    public boolean canPartition3(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0)
            return false;
        int[] dp = new int[sum / 2];
        return doDp(sum / 2, 0, 0, nums, dp);

    }

    public boolean doDp(int max, int cur, int index, int[] nums, int[] dp) {
        if (cur > max || index >= nums.length) {
            return false;
        } else if (cur == max) {
            return true;
        }
        if (dp[cur] == 1) {
            return true;
        } else if (dp[cur] == -1) {
            return false;
        }
        boolean res = doDp(max, cur + nums[index], index + 1, nums, dp)
                || doDp(max, cur, index + 1, nums, dp);
        dp[cur] = res ? 1 : -1;
        return res;
    }

    /**
     * DFS
     *
     * @param nums
     * @return
     */
    public boolean canPartition4(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return 0 == (sum & 1) && helper(nums, 0, (sum >> 1));
    }

    private boolean helper(int[] nums, int begin, int target) {
        if (target <= 0 || begin >= nums.length)
            return 0 == target;
        return helper(nums, begin + 1, target - nums[begin])
                || helper(nums, begin + 1, target);
    }

    /**
     * DP
     *
     * @param nums
     * @return
     */
    public boolean canPartition5(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (1 == (sum & 1))
            return false;
        int v = (sum >> 1);
        boolean[] dp = new boolean[v + 1];
        dp[0] = true;
        for (int n : nums) {
            for (int i = v; i >= n; --i) {
                dp[i] |= dp[i - n];
            }
            if (dp[v])
                return true;
        }
        return dp[v];
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
