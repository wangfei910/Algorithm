package Algorithm.LeetCode.T46;

import java.util.ArrayList;
import java.util.List;

/**
 * 排列
 * <p>
 * 给定一个不同整数的集合,返回所有可能的排列。
 *
 * @author: wangfei
 * @date: 2019/5/30 21:51
 */
public class Solution {

    /**
     * 递归 + 回溯
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        generatePermute(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    /**
     * @param res
     * @param list
     * @param nums
     * @param used 标记元素是否被用过
     */
    private static void generatePermute(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i])
                    continue;
//                if (list.contains(nums[i]))
//                    continue;
                used[i] = true;
                list.add(nums[i]);
                generatePermute(res, list, nums, used);
                //状态回溯
                used[i] = false;
                //删除最后一个元素
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
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }

}
