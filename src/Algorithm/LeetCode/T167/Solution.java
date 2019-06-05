package Algorithm.LeetCode.T167;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两个Sum II - 输入有序数组
 *
 * @author: wangfei
 * @date: 2019/4/8 19:37
 */
public class Solution {

    /**
     * 对撞指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * <p>
     * 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
     * 如果 sum > target，移动较大的元素，使 sum 变小一些；
     * 如果 sum < target，移动较小的元素，使 sum 变大一些。
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    /**
     * 二分查找
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers.length < 2)
            return res;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                 res[0] = map.get(target - numbers[i]) + 1;
                 res[1] = i + 1;
                 return res;
            }
            map.put(numbers[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.print(Arrays.toString(twoSum2(numbers, target)));
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start) + "ms");
    }
}
