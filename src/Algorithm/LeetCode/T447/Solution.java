package Algorithm.LeetCode.T447;

import java.util.HashMap;
import java.util.Map;

/**
 * 数量的最大化
 * <p>
 * 给定平面上n个成对不同的点，一个“回飞棒”是一个点的元组(i, j, k)，这样i和j之间的距离等于i和k之间的距离(元组的顺序很重要)。
 * 找出回力棒的数量。您可以假设n最多为500，并且点的坐标都在[-10000,10000](包括)范围内。
 *
 * @author: wangfei
 * @date: 2019/5/22 0:56
 */
public class Solution {

    /**
     * 查找表
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     *
     * @param points
     * @return
     */
    public static int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            map.clear();
            for (int j = 0; j <points.length; j++) {
                if (i == j) {
                    continue;
                }
                int distance = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) +
                        (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                int count = map.getOrDefault(distance, 0);
                res += count++ * 2;
                map.put(distance, count);
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
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println(numberOfBoomerangs(points));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
