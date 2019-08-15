package Algorithm.Test.Sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 时间复杂度：O(n^2)
 *
 * @author: wangfei
 * @date: 2019/5/25 23:36
 */
public class Bubble_Sort {

    /**
     * 5,7,2,9,4,1,0,5,7		共需要比较length-1轮
     * 5,7,2,9,4,1,0,5,7
     * 5,2,7,9,4,1,0,5,7
     * 5,2,7,4,1,0,5,7,9
     * 2,5
     */
    public static int[] bubbleSort(int[] arr) {
        //控制共比较多少轮
        for (int i = 0; i < arr.length - 1; i++) {
            //控制比较的次数
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
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
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }

}
