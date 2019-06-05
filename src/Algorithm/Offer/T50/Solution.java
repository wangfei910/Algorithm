package Algorithm.Offer.T50;

import java.util.HashSet;

/**
 * 数组中重复的数字
 *
 * @author: wangfei
 * @date: 2019/5/11 20:48
 */
public class Solution {

    /**
     * HashSet
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public static boolean duplicate(int numbers[], int length, int[] duplication) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (set.add(numbers[i])) {
                continue;
            } else {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    /**
     * 辅助数组记录
     * 1、新开一个长为 length 的数组 arr，遍历 numbers，将数组中的数字作为索引在 arr 中实时统计数字出现的次数
     * 2、如果出现的次数等于 2，则表示此数字重复
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public static boolean duplicate2(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length == 0)
            return false;
        int[] arr = new int[length];
        duplication[0] = -1;
        for (int i = 0; i < length; i++) {
            if (++arr[numbers[i]] == 2) {
                duplication[0] = numbers[i];
                break;
            }
        }
        return duplication[0] != -1;
    }

    /**
     * 调整交换位置
     * 1、O(N) + O(1)
     * 2、将值为 i 的元素调整到第 i 个位置上，若该位置有数字，则说明重复
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public static boolean duplicate3(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length == 0)
            return false;
        int i = 0;
        while (numbers[i] != i && i < length) {
            if (numbers[i] == numbers[numbers[i]]) {
                duplication[0] = numbers[i];
                return true;
            }
            swap(numbers, i, numbers[i]);
        }
        return false;
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }


    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int numbers[] = {2, 4, 1, 0, 2, 5, 3};
        int length = 7;
        int[] duplication = new int[1];
        System.out.println(duplicate3(numbers, length, duplication));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
