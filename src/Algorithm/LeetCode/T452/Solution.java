package Algorithm.LeetCode.T452;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 投飞镖刺破气球
 *
 * @author: wangfei
 * @date: 2019/4/17 16:12
 */
public class Solution {

    /**
     * 气球在一个水平数轴上摆放，可以重叠，飞镖垂直投向坐标轴，使得路径上的气球都会刺破。
     * 求解最小的投飞镖次数使所有气球都被刺破。
     * <p>
     * 也是计算不重叠的区间个数，和 Non-overlapping Intervals 的区别在于，[1, 2] 和 [2, 3] 在本题中算是重叠区间。
     *
     * @param points
     * @return
     */
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0){
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int count = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] < end) {
                continue;
            }
            count++;
            end = points[i][1];
        }
        return count;
    }

    public static int findMinArrowShots1(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o1[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        int start = points[0][0];
        int end = points[0][1];
        int count = 1;
        for (int i = 0; i < points.length; i++) {
            int newStart = points[i][0];
            int newEnd = points[i][1];
            if (newStart <= end) {
                end = Math.min(newEnd, end);
            } else {
                count++;
                start = newStart;
                end = newEnd;
            }
        }
        return count;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(findMinArrowShots(points));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
