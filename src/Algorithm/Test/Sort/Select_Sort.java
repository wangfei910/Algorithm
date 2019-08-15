package Algorithm.Test.Sort;

import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度：O(N^2)
 *
 * @author: wangfei
 * @date: 2019/5/25 23:38
 */
public class Select_Sort {

    public static int[] selectSort(int[] arr) {
        //遍历所有的数
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            //把当前遍历的数和后面所有的数依次进行比较，并记录下最小的数的下标
            for (int j = i + 1; j < arr.length; j++) {
                //如果后面比较的数比记录的最小的数小。
                if (arr[minIndex] > arr[j]) {
                    //记录下最小的那个数的下标
                    minIndex = j;
                }
            }
            //如果最小的数和当前遍历数的下标不一致,说明下标为minIndex的数比当前遍历的数更小。
            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
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
        System.out.println(Arrays.toString(selectSort(arr)));
    }
}
