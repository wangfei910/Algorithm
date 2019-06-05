package Algorithm.LeetCode.T153;

/**
 * 查找旋转数组的最小数字
 * <p>
 * 假设一个按升序排序的数组在某个未知的主轴上旋转。(即 [0,1,2,4,5,6,7] 可能成为 [4、5、6、7 0,1,2])。
 * 找出最小的元素,您可以假设数组中不存在副本。
 *
 * @author: wangfei
 * @date: 2019/4/28 20:44
 */
public class Solution {

    public static int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] <= nums[h]) {
                h = mid;
            } else {
                l = mid + 1;
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
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(nums));
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start) + "ms");
    }
}
