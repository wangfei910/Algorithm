package Algorithm.Offer.T64;

import java.util.ArrayList;

/**
 * 滑动窗口的最大值
 * <p>
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 *
 * @author: wangfei
 * @date: 2019/5/16 10:50
 */
public class Solution {

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> resList = new ArrayList<>();
        if (num == null || num.length == 0 || size == 0)
            return resList;
        for (int i = 0; i <= num.length - size; i++) {
            int max = 0;
            for (int j = i; j < i + size; j++) {
                if (num[j] > max) {
                    max = num[j];
                }
            }
            resList.add(max);
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
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        System.out.println(maxInWindows(num, size));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
