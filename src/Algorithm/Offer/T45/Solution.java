package Algorithm.Offer.T45;

import java.util.Arrays;

/**
 * 扑克牌顺子
 *
 * @author: wangfei
 * @date: 2019/5/11 16:04
 */
public class Solution {

    /**
     * 1、排序
     * 2、统计大小王出现次数
     * 3、大小王补有序数列
     *
     * @param numbers
     * @return
     */
    public static boolean isContinous(int[] numbers) {
        if (numbers.length < 5)
            return false;
        Arrays.sort(numbers);
        int count = 0;
        for (int num : numbers) {
            if (num == 0) {
                count++;
            }
        }
        for (int i = count; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                return false;
            } else {
                // 两数之间控几个数就用几个大小王来补
                count -= (numbers[i + 1] - numbers[i] - 1);
            }
        }
        return count >= 0;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] numbers = {1, 2, 3, 9, 5, 6, 7, 0};
        System.out.println(isContinous(numbers));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
