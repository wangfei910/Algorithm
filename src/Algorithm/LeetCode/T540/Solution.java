package Algorithm.LeetCode.T540;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 有序数组中的单个元素
 * <p>
 * 给定一个只包含整数的有序数组，其中每个元素出现两次，只有一个元素出现一次。找到这个只出现一次的元素
 *
 * @author: wangfei
 * @date: 2019/4/28 19:27
 */
public class Solution {

    /**
     * 1、假设 index 为 Single Element 在数组中的索引位置， m 为偶数
     * 2、若 m + 1 < index，那么 nums[m] == nums[m + 1]，index 所在的数组位置为 [m + 2, h]
     * 3、若 m + 1 >= index，那么 nums[m] != nums[m + 1]，index 所在的数组位置为 [l, m]
     * <p>
     * 时间复杂度为 O(logN)
     *
     * @param nums
     * @return
     */
    public static int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            //保证l、h、mid都在偶数位，使得查找区间大小一致都是奇数
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            } else {
                h = mid;
            }
        }
        return nums[l];
    }


    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(singleNonDuplicate(nums));
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start) + "ms");
    }
}
