package Algorithm.LeetCode.T435;

import Algorithm.common.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 不重叠的区间个数
 *
 * @author: wangfei
 * @date: 2019/4/17 13:10
 */
public class Solution {

    public static int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        int count = 1;
        int end = intervals[0].end;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < end) {
                continue;
            }
            end = intervals[i].end;
            count++;
        }
        return intervals.length - count;
    }


    public static int eraseOverlapIntervals1(Interval[] intervals) {
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.end - b.end);
        for (Interval i : intervals) {
            pq.offer(i);
        }
        int pre = Integer.MIN_VALUE, count = 0;
        while (pq.size() > 0) {
            Interval cur = pq.poll();
            if (cur.start >= pre) {
                pre = cur.end;
            } else {
                count++;
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
//        Interval[] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
//        System.out.println(eraseOverlapIntervals(intervals));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
