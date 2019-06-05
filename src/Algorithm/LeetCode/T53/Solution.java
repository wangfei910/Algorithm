package Algorithm.LeetCode.T53;

/**
 * 子数组最大的和
 * <p>
 * 给定整数数组，找到具有最大和的相邻子数组(至少包含一个数字)并返回其和。
 *
 * @author: wangfei
 * @date: 2019/4/21 23:10
 */
public class Solution {

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int curSum = nums[0];
        int maxSum = curSum;
        for (int i = 1; i < nums.length; i++) {
            curSum = curSum > 0 ? curSum + nums[i] : nums[i];
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }


    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
