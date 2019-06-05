package Algorithm.LeetCode.T34;

import java.util.Arrays;

/**
 * 查找有序数组中元素的第一个和最后一个位置
 * <p>
 * 给定一个按升序排序的整数数组，找出给定目标值的起始和结束位置。
 * 算法的时复杂度必须是 O(log n) ,如果数组中没有找到目标，则返回[- 1,1]。
 *
 * @author: wangfei
 * @date: 2019/4/28 21:03
 */
public class Solution {

    public static int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums, target);
        int last = binarySearch(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        }else {
            return new int[]{first, Math.max(first, last)};
        }
    }

    public static int binarySearch(int[] nums, int target) {
        int l = 0, h = nums.length;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] >= target) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 6;
        System.out.println(Arrays.toString(searchRange(nums, target)));
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start) + "ms");
    }
}
