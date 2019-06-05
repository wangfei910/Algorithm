package Algorithm.LeetCode.T75;

import java.util.Arrays;

/**
 * 按颜色进行排序
 *
 * @author: wangfei
 * @date: 2019/4/16 15:30
 */
public class Solution {

    /**
     * 有三种颜色的球，算法的目标是将这三种球按颜色顺序正确地排列。
     * 它其实是三向切分快速排序的一种变种，在三向切分快速排序中，每次切分都将数组分成三个区间：
     * 小于切分元素、等于切分元素、大于切分元素，而该算法是将数组分成三个区间：等于红色、等于白色、等于蓝色。
     *
     * @param nums
     * @return
     */
    public static int[] sortColors(int[] nums) {
        int zero = -1, one = 0, two = nums.length;
        while (one < two) {
            if (nums[one] == 0) {
                swap(nums, ++zero, one++);
            } else if (nums[one] == 2) {
                swap(nums, --two, one);
            } else {
                ++one;
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int[] sortColors2(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++)
            count[nums[i]]++;
        for (int i = 0; i < count[0]; i++)
            nums[i] = 0;
        for (int i = count[0]; i < count[0] + count[1]; i++)
            nums[i] = 1;
        for (int i = count[0] + count[1]; i < count[0] + count[1] + count[2]; i++)
            nums[i] = 2;
        return nums;
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public static int[] sortColors3(int[] nums) {
        int zero = -1;           //nums[0...zero] == 0
        int two = nums.length;   //nums[two...n-1] == 2
        for (int i = 0; i < two;) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                swap1(nums, i++, ++zero);
            } else if (nums[i] == 2) {
                swap1(nums, i, --two);
            }
        }
        return nums;
    }

    private static void swap1(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] nums = {2, 0, 2, 1, 1, 0, 0, 1, 2, 1};
        System.out.println(Arrays.toString(sortColors3(nums)));
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start) + "ms");
    }
}
