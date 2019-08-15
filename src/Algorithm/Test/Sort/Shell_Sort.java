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

    public static int[] shellSort(int[] arr) {
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
        return arr;
    }

    public static void main(String[] args) {
        int length = 10;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(shellSort(arr)));
    }
}
