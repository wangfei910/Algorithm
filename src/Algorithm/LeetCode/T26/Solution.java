package Algorithm.LeetCode.T26;

/**
 * 从已排序数组中移除重复元素
 * <p>
 * 给定一个已排序的数组，删除重复项，使每个元素只出现一次，并返回新的长度。
 * 不要为另一个数组分配额外的空间，您必须使用O(1)额外内存修改输入数组。
 *
 * @author: wangfei
 * @date: 2019/5/19 9:57
 */
public class Solution {

    public static int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        return nums.length - count;
    }

    public static int removeDuplicates2(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static int removeDuplicates3(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i > 1 || num > nums[i - 1]) {
                nums[i++] = num;
            }
        }
        return i;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates2(nums));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
