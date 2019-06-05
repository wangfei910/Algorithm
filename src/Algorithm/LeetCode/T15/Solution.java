package Algorithm.LeetCode.T15;

import java.util.*;

/**
 * 三个数之和
 * <p>
 * 给定一个包含n个整数的数组，在数组中是否存在a、b、c元素使得a + b + c = 0?找出数组中所有唯一的三元组，它们的和为零。
 * 注意:
 * 解决方案集不能包含重复的三元组。
 *
 * @author wangfei
 */
public class Solution {

    /**
     * 暴力解法
     * 时间复杂度：O(n^3)
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        //元素去重
                        set.add(list);
                    }
                }
            }
        }
        res.addAll(set);
        return res;
    }

    /**
     * 对撞指针
     * 时间复杂度：O(nlogn)
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 3)
            return res;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int begin = i + 1, end = len - 1;
            while (begin < end) {
                int sum = nums[i] + nums[begin] + nums[end];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[begin]);
                    list.add(nums[end]);
                    res.add(list);
                    begin++;
                    end--;
                    while (begin < end && nums[begin] == nums[begin - 1]) begin++;
                    while (begin < end && nums[end] == nums[end + 1]) end--;
                } else if (sum > 0) end--;
                else begin++;
            }
        }
        return res;
    }


    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] nums = {0, 0, 1, 0, 2, 0};
        System.out.println(threeSum(nums));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}