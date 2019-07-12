package Algorithm.LeetCode.T300;

import java.util.Arrays;

/**
 * 最长上升子序列
 * <p>
 * 给定一个未排序的整数数组，求其最长递增子序列的长度。
 * 例子:
 * 输入:[10 9、2、5、3、7101年,18)
 * 输出:4
 * 说明:最长递增子序列为[2,3,7,101]，因此长度为4。
 * 注意:
 * 可能有多个LIS组合，只需要返回长度即可。
 * 您的算法应该在O(n2)复杂度下运行。
 *
 * @author: wangfei
 * @date: 2019/6/19 9:49
 */
public class Solution {

    /**
     * DP
     * 时间复杂度：O(N^2)
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        // memo[i] 表示以 nums[i] 为结尾的最长上升子序列的长度
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                }
            }
        }
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, memo[i]);
        }
        return res;
    }

    /**
     * 双指针
     * 时间复杂度：O(nlogn)
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS2(int[] nums) {
        int[] memo = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int i = 0, j = size;
            while (i != j) {
                int mid = i + (j - i) / 2;
                if (memo[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            memo[i] = num;
            if (i == size) {
                ++size;
            }
        }
        return size;
    }


    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
