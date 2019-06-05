package Algorithm.LeetCode.T80;

/**
 * 从已排序数组中移除重复元素 II
 * <p>
 * 给定已排序的数组，删除重复项，使重复项最多出现两次，并返回新的长度。
 * 不要为另一个数组分配额外的空间，您必须使用O(1)额外内存修改输入数组。
 *
 * @author: wangfei
 * @date: 2019/5/19 10:24
 */
public class Solution {

    public static int removeDuplicates(int[] nums) {
        int j = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[j - 2]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i - 2]) {
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
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(nums));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
