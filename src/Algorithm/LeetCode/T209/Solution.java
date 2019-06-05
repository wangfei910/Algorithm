package Algorithm.LeetCode.T209;

/**
 * 最小子数组大小和
 * <p>
 * 给定一个由n个正整数和一个正整数s组成的数组，找出其和≥s的相邻子数组的最小长度。如果没有，则返回0。
 *
 * @author: wangfei
 * @date: 2019/5/19 19:58
 */
public class Solution {

    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int s, int[] nums) {
        //nums[l...r]为我们的滑动窗口
        int l = 0, r = -1;
        int sum = 0;
        int res = nums.length + 1;
        while (l < nums.length) {
            if (r + 1 < nums.length && sum < s) {
                r++;
                sum += nums[r];
            } else {
                sum -= nums[l];
                l++;
            }
            if (sum >= s) {
                res = Math.min(res, r - l + 1);
            }
        }
        if (res == nums.length + 1)
            return 0;
        return res;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int s = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(s, nums));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
