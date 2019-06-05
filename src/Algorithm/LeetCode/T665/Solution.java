package Algorithm.LeetCode.T665;

/**
 * 修改一个数成为非递减数组
 * <p>
 * 给定一个有n个整数的数组，检查它是否可以通过最多修改一个元素而变为非递减。
 * 如果数组[i] <=数组[i + 1]适用于每个i (1 <= i < n)，则定义数组为非递减数组。
 *
 * @author: wangfei
 * @date: 2019/4/21 22:48
 */
public class Solution {

    /**
     * 在出现 nums[i] < nums[i - 1] 时，需要考虑的是应该修改数组的哪个数，使得本次修改能使 i 之前的数组
     * 成为非递减数组，并且不影响后续的操作。优先考虑令 nums[i - 1] = nums[i]，因为如果修改
     * nums[i] = nums[i - 1] 的话，那么 nums[i] 这个数会变大，就有可能比 nums[i + 1] 大，从而影响了后续操作。
     * 还有一个比较特别的情况就是 nums[i] < nums[i - 2]，只修改 nums[i - 1] = nums[i] 不能使数组成为非递减数组，
     * 只能修改 nums[i] = nums[i - 1]。
     *
     * @param nums
     * @return
     */
    public static boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length && count < 2; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            count++;
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            }else {
                nums[i - 1] = nums[i];
            }
        }
        return count <= 1;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] nums = {4, 2, 3};
        System.out.println(checkPossibility(nums));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
