package Algorithm.Test.Sort;

import java.util.Arrays;

/**
 * 快速排序
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(log(n))
 *
 * @author: wangfei
 * @date: 2019/5/25 23:37
 */
public class Quick_Sort {

    /**
     * 两路快排
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static int[] quickSort(int[] arr, int start, int end) {
        if (start < end) {
            //把数组中的第0个数字做为标准数
            int stard = arr[start];
            //记录需要排序的下标
            int low = start;
            int high = end;
            //循环查找比标准数大的数和比标准数小的数
            while (low < high) {
                //如果右边的数字比标准数大
                while (low < high && stard <= arr[high]) {
                    high--;
                }
                //否则使用右边的数字替换左边的数
                arr[low] = arr[high];
                //如果左边的数字比标准数小
                while (low < high && arr[low] <= stard) {
                    low++;
                }
                //否则使用左边的数字替换右边的数
                arr[high] = arr[low];
            }
            //把标准数赋给低所在的位置的元素
            arr[low] = stard;
            //处理所有的小的数字
            quickSort(arr, start, low);
            //处理所有的大的数字
            quickSort(arr, low + 1, end);
        }
        return arr;
    }

    /**
     * 三路快排
     * 1、将arr[start...end]分为小于 v 、等于 v 和大于 v 三部分
     * 2、递归对小于 v 和大于 v 两部分分别继续进行三路快排
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static int[] quickSort3Ways(int[] arr, int start, int end) {
        if (start <end) {
//        if (end - start <= 15) {
//            Insertion_Sort(arr, start, end);
//            return arr;
//        }
            int v = arr[start];
            //arr[start+1...lt] < v
            int lt = start;
            //arr[gt...end] > v
            int gt = end + 1;
            //arr[lt+1...i] == v
            int i = start + 1;
            while (i < gt) {
                if (arr[i] < v) {
                    swap(arr, i, lt + 1);
                    lt++;
                    i++;
                } else if (arr[i] > v) {
                    swap(arr, i, gt - 1);
                    gt--;
                } else {
                    i++;
                }
            }
            swap(arr, start, lt);
            quickSort3Ways(arr, start, lt - 1);
            quickSort3Ways(arr, gt, end);
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int length = 10;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(arr));
        int Start = 0;
        int End = arr.length - 1;
        System.out.println(Arrays.toString(quickSort(arr, Start, End)));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }

}
