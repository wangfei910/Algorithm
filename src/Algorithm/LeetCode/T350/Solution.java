package Algorithm.LeetCode.T350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 两个数组的交集II
 * <p>
 * 给定两个数组，写一个函数来计算它们的交集。
 *
 * @author: wangfei
 * @date: 2019/5/21 0:44
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
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[0];
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (count.containsKey(nums1[i])) {
                count.put(nums1[i], count.get(nums1[i]) + 1);
            } else {
                count.put(nums1[i], 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (count.containsKey(nums2[i]) && count.get(nums2[i]) > 0) {
                list.add(nums2[i]);
                count.put(nums2[i], count.get(nums2[i]) - 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
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
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
