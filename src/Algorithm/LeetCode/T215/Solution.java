package Algorithm.LeetCode.T215;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 找出未排序数组中第k大的元素
 *
 * @author: wangfei
 * @date: 2019/4/9 22:53
 */
public class Solution {

    /**
     * 数组排序（默认升序）：时间复杂度 O(NlogN)，空间复杂度 O(1)
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 堆排序 ：时间复杂度 O(NlogK)，空间复杂度 O(K)。
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest1(int[] nums, int k) {
        // 小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.add(val);
            // 维护堆的大小为 K
            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }

    /**
     * 快速选择 ：时间复杂度 O(N)，空间复杂度 O(1)
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest2(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private static int partition(int[] a, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (a[++i] < a[l] && i < h) ;
            while (a[--j] > a[l] && j > l) ;
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 3;
        System.out.println(findKthLargest2(nums, k));
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start) + "ms");
    }
}
