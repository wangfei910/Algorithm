package Algorithm.LeetCode.T27;

/**
 * 删除元素
 * <p>
 * 给定数组号和值val，删除该值的所有实例并返回新的长度。
 * 不要为另一个数组分配额外的空间，您必须使用O(1)额外内存修改输入数组。
 * 元素的顺序可以改变。在新的长度之外留下什么并不重要。
 *
 * @author: wangfei
 * @date: 2019/5/19 9:07
 */
public class Solution {

    public static int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (i != j) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    j++;
                } else {
                    j++;
                }
            }
        }
        return j;
    }


    public static int removeElement2(int[] nums, int val) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == val) {
                nums[i--] = nums[length-- - 1];
            }
        }
        return length;
    }

    public static int removeElement3(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.out.println(removeElement3(nums, val));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
