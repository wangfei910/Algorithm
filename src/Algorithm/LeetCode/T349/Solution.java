package Algorithm.LeetCode.T349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 两个数组的交集
 *
 * @author: wangfei
 * @date: 2019/5/21 0:14
 */
public class Solution {

    /**
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        for (int num1 : nums1) {
            set.add(num1);
        }
        Set<Integer> resSet = new HashSet<>();
        for (int num2 : nums2) {
            if (set.contains(num2)) {
                resSet.add(num2);
            }
        }
        int[] res = new int[resSet.size()];
        int i = 0;
        for (int num : resSet) {
            res[i++] = num;
        }
        return res;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
