package Algorithm.LeetCode.T198;

/**
 * 房子强盗
 * <p>
 * 你是一个计划沿街抢劫房屋的职业强盗。每个房子都有一定数量的钱被藏起来，阻止你抢劫他们的唯一限制是相邻的房子都有安全系统连接，如果两个相邻的房子在同一天晚上被闯入，它会自动联系警察。
 * 给出一个非负整数列表，表示每户人家的钱数，确定你今晚不报警就能抢劫的最大钱数。
 *
 * @author: wangfei
 * @date: 2019/6/5 23:40
 */
public class Solution {

    /**
     * 递归（可能会超时）
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        return tryRob(nums, 0);
    }

    //考虑抢劫nums[index...nums.length - 1]这个范围的所有房子
    private static int tryRob(int[] nums, int index) {
        if (nums == null || nums.length == 0)
            return 0;
        if (index >= nums.length)
            return 0;
        int res = 0;
        int[] memo = new int[nums.length];
        if (memo[index] != 0)
            return memo[index];
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + tryRob(nums, i + 2));
        }
        memo[index] = res;
        return res;
    }

    /**
     * 动态规划：O(N^2)
     *
     * @param nums
     * @return
     */
    public static int rob2(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        //memo[i]表示考虑抢劫nums[i...n-1]所能获得的最大利益
        int[] memo = new int[n];
        memo[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            //memo[i]
            for (int j = i; j < n; j++) {
                memo[i] = Math.max(memo[i], nums[j] + (j + 2 < n ? memo[j + 2] : 0));
            }
        }
        return memo[0];
    }

    /**
     * 动态规划：O(N)
     *
     * @param nums
     * @return
     */
    public static int rob3(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] dp = {nums[0], Math.max(nums[0], nums[1])};
        int index = 0;
        for (int i = 2; i < nums.length; i++) {
            //i&1 === i%2
            index = i & 1;
            //index^1：0 -> 1, 1 -> 0
            dp[index] = Math.max(nums[i] + dp[index], dp[index ^ 1]);
        }
        return Math.max(dp[0], dp[1]);
    }

    /**
     * 动态规划：O(N)
     *
     * @param nums
     * @return
     */
    public static int rob4(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] mark = new int[nums.length];
        //我们可以从问题中推导出公式:mark[i]=max(num[i]+mark[i-2]，mark[i-1])
        mark[0] = nums[0];
        mark[1] = Math.max(nums[0], nums[1]);

        //使用动态规划来标记最大的钱
        for (int i = 2; i < nums.length; i++) {
            mark[i] = Math.max(nums[i] + mark[i - 2], mark[i - 1]);
        }
        return mark[nums.length - 1];
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob2(nums));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
