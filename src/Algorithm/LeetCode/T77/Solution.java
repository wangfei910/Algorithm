package Algorithm.LeetCode.T77;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * <p>
 * 给定两个整数n和k，返回1…n。
 *
 * @author: wangfei
 * @date: 2019/5/31 0:02
 */
public class Solution {

    private static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n)
            return res;
        List<Integer> list = new ArrayList<>();
        generateCombine(n, k, 1, list);
        return res;
    }


    //当前已经找到的组合存储在list中，需要从start开始搜索新的元素
    private static void generateCombine(int n, int k, int start, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        //还有 k-list.size() 个空位，所以至少还要这么多个元素
        //i最多为 n - (k - list.size()) + 1
        for (int i = start; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            generateCombine(n, k, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int n = 1, k = 1;
        System.out.println(combine(n, k));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
