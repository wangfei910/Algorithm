package Algorithm.LeetCode.T239;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 返回滑动窗口中的最大值
 *
 * @author wangfei
 */
public class Solution {

    /**
     * 注：Java中默认优先队列就是小顶堆，且一个数越大其相反数越小
     * 1.创建一个优先队列，将前两个数组元素的相反数放入优先队列中
     * 2.遍历数组中其余元素的相反数依次放入优先队列构建小顶堆
     * 3.将堆顶元素的相反数（即原数组中的数）存入max数组中
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k <= 0)
            return new int[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k - 1; i++) {
            queue.add(-nums[i]);
        }
        int[] max = new int[nums.length - k + 1];
        for (int i = 0, j = k - 1; j < nums.length; i++, j++) {
            queue.add(-nums[j]);
            max[i] = -queue.peek();
            queue.remove(-nums[j - k + 1]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.print(Arrays.toString(maxSlidingWindow(nums, k)));
    }
}
