package Algorithm.LeetCode.T47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排序II
 * <p>
 * 给定一组可能包含重复项的数字，返回所有可能的惟一排列。
 *
 * @author: wangfei
 * @date: 2019/5/30 22:25
 */
public class Solution {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                    continue;
                used[i] = true;
                list.add(nums[i]);
                backtrack(res, list, nums, used);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }


    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
