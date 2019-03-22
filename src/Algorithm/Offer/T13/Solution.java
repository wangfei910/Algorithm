package Algorithm.Offer.T13;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 *
 * @author wangfei
 */
public class Solution {
    /**
     * 1.计算数组中奇数的个数
     * 2.新开一个复制数组，遍历数组，奇数从 0 开始添加，偶数从计数后开始添加
     *
     * @param array
     */
    public static int[] reOrderArray(int[] array) {
        int oddCount = 0;
        for (int item : array) {
            if (item % 2 == 1)
                oddCount++;
        }
        int[] copy = array.clone();
        int index = 0;
        for (int item : copy) {
            if (item % 2 == 1)
                array[index++] = item;
            else
                array[oddCount++] = item;
        }
        return array;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] array = new int[]{2, 3, 4, 1, 6, 7, 5, 8, 9};
        System.out.println(Arrays.toString(reOrderArray(array)));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
