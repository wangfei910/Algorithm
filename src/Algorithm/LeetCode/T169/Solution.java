package Algorithm.LeetCode.T169;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Majority Element
 *
 * @author wangfei
 */
public class Solution {

    /**
     * Boyer-Moore多数投票算法
     * 时间复杂度为O(N)
     *
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {
        int count = 0, majority = 0;
        for (int num : nums) {
            if (count == 0) {
                majority = num;
            } else if (majority == num) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }

    /**
     * 1.创建一个map，遍历数组，若该数组元素存在于map中则将其个数加1，
     * 否则将该元素放入map中并将其个数置为1.
     * 2.将每个元素个数与数组长度的一半进行比较，返回大于数组长度一半着
     * 注：时间复杂度为O(N)
     *
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        int majority = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (!map.containsKey(n))
                map.put(n, 1);
            else
                map.put(n, map.get(n) + 1);
            if (map.get(n) > nums.length / 2) {
                majority = n;
            }
        }
        return majority;
    }

    /**
     * 对数组元素进行排序，中间位置的元素即为所求值
     * 时间复杂度为O(NlogN)
     *
     * @param nums
     * @return
     */
    public static int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 利用位操作进行处理
     * 因为序列中的数都是 int 型（32位），故分别统计序列中每一个数每一位出现的次数，
     * 大于n/2的位即属于出现次数大于n/2的那个数，把属于的位合并，得到最终结果。
     * 思想是Divide and Conquer
     * 时间复杂度为O(NlogN)
     *
     * @param nums
     * @return
     */
    public static int majorityElement4(int[] nums) {
        int[] bit = new int[32];
        for (int num : nums)
            for (int i = 0; i < 32; i++)
                if ((num >> (31 - i) & 1) == 1)
                    bit[i]++;
        int majority = 0;
        for (int i = 0; i < 32; i++) {
            bit[i] = bit[i] > nums.length / 2 ? 1 : 0;
            majority += bit[i] * (1 << (31 - i));
        }
        return majority;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
//        System.out.print(majorityElement1(nums));
//        System.out.print(majorityElement2(nums));
//        System.out.print(majorityElement3(nums));
        System.out.print(majorityElement4(nums));
    }
}
