package Algorithm.LeetCode.T120;

import java.util.List;

/**
 * 三角形
 *
 * @author: wangfei
 * @date: 2019/4/18 20:35
 */
public class Solution {

    /**
     * 动态规划
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[] mini = new int[triangle.get(m - 1).size()];
        for (int i = 0; i < n; i++) {
            mini[i] = triangle.get(m - 1).get(i);
        }
        for (int i = n; i >= 0; i--) {
            List<Integer> cur = triangle.get(i);
            for (int j = 0; j < cur.size(); j++) {
                mini[j] = Math.min(mini[j], mini[j + 1]) + cur.get(j);
            }
        }
        return mini[0];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> pre = triangle.get(i - 1);
            List<Integer> cur = triangle.get(i);
            cur.set(0, cur.get(0) + pre.get(0));
            cur.set(i, cur.get(i) + pre.get(i - 1));
            for (int j = 1; j < i; j++) {
                cur.set(j, cur.get(j) + Math.min(pre.get(j), pre.get(j + 1)));
            }
        }
        int min = Integer.MAX_VALUE;
        for (int num :triangle.get(triangle.size() - 1)) {
            if (num < min)
                min = num;
        }
        return min;
    }
}
