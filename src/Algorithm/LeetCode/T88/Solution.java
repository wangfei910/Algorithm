package Algorithm.LeetCode.T88;

import java.util.Arrays;

/**
 * 归并两个有序数组
 *
 * @author: wangfei
 * @date: 2019/4/8 21:13
 */
public class Solution {

    /**
     * 把归并结果存到第一个数组上。
     * 需要从尾开始遍历，否则在 nums1 上归并得到的值会覆盖还未进行归并比较的值。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int mergeIndex = m + n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                nums1[mergeIndex--] = nums1[index2--];
            } else if (index2 < 0) {
                nums1[mergeIndex--] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {
                nums1[mergeIndex--] = nums1[index1--];
            } else {
                nums1[mergeIndex--] = nums2[index2--];
            }
        }
        return nums1;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        System.out.println(Arrays.toString(merge(nums1, m, nums2, n)));
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start) + "ms");
    }
}
