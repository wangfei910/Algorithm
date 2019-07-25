package Algorithm.Test.Sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 时间复杂度：O(n^2)
 *
 * @author: wangfei
 * @date: 2019/5/25 23:38
 */
public class Shell_Sort {

    public static void shellSort(int[] arr) {
        int k = 1;
        // 遍历所有的步长
        for (int d = arr.length / 2; d > 0; d /= 2) {
            // 遍历所有有元素
            for (int i = d; i < arr.length; i++) {
                // 遍历本组中所有的元素
                for (int j = i - d; j >= 0; j -= d) {
                    // 如果当前元素大于加上步长后的那个元素
                    if (arr[j] > arr[j + d]) {
                        int temp = arr[j];
                        arr[j] = arr[j + d];
                        arr[j + d] = temp;
                    }
                }
            }
            System.out.println("第" + k + "次排序结果：" + Arrays.toString(arr));
            k++;
        }
    }

}
