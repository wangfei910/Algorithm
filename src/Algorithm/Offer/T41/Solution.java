package Algorithm.Offer.T41;

import java.util.ArrayList;

/**
 * 和为 S 的连续正数序列
 * <p>
 * 输出所有和为 S 的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * @author: wangfei
 * @date: 2019/5/8 23:11
 */
public class Solution {

    /**
     * 链表实现滑动窗口
     * 维护一个链表，当链表和大于 sum，就不断删除链表头元素，直到链表和小于等于 sum
     *
     * @param sum
     * @return
     */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        if (sum <= 1)
            return resList;
        int totalSum = 0;
        for (int i = 1; i < sum; i++) {
            totalSum += i;
            list.add(i);
            while (totalSum > sum) {
                // 删除链表表头元素
                int val = list.get(0);
                totalSum -= val;
                list.remove(0);
            }
            if (totalSum == sum) {
                resList.add(new ArrayList(list));
            }
        }
        return resList;
    }

    /**
     * 双指针实现滑动窗口
     * totalSum 为 start 指针到当前 i 元素的和，如果和大于 sum，start 不断向前移动，直到和小于 sum；
     * 当 totalSum == sum 时，遍历 start 到当前元素 i，添加到链表中
     *
     * @param sum
     * @return
     */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        if (sum <= 1)
            return resList;
        int totalSum = 0;
        int start = 1;
        for (int i = 1; i < sum; i++) {
            totalSum += i;
            while (totalSum > sum) {
                totalSum -= start;
                start++;
            }
            if (totalSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = start; j <= i; j++) {
                    list.add(j);
                }
                resList.add(new ArrayList(list));
            }
        }
        return resList;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int sum = 100;
        System.out.println(FindContinuousSequence2(sum));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
