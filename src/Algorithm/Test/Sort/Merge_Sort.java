package Algorithm.Test.Sort;

import java.util.Arrays;

/**
 * 归并排序
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(n)
 *
 * @author: wangfei
 * @date: 2019/5/25 23:39
 */
public class Merge_Sort {

    public static int[] mergeSort(int[] arr, int low, int high) {
        int middle = low + (high - low) / 2;
        if (low < high) {
            //处理左边
            mergeSort(arr, low, middle);
            //处理右边
            mergeSort(arr, middle + 1, high);
            //归并
            merge(arr, low, middle, high);
        }
        return arr;
    }


    public static void merge(int[] arr, int low, int middle, int high) {
        //用于存储归并后的临时数组
        int[] temp = new int[high - low + 1];
        //记录第一个数组中需要遍历的下标
        int i = low;
        //记录第二个数组中需要遍历的下标
        int j = middle + 1;
        //用于记录在临时数组中存放的下标
        int index = 0;
        //遍历两个数组取出小的数字，放入临时数组中
        while (i <= middle && j <= high) {
            //第一个数组的数据更小
            if (arr[i] <= arr[j]) {
                //把小的数据放入临时数组中
                temp[index++] = arr[i++];
            } else {
                temp[index++] = arr[j++];
            }
        }
        //处理多余的数据
        while (j <= high) {
            temp[index++] = arr[j++];
        }
        while (i <= middle) {
            temp[index++] = arr[i++];
        }
        //把临时数组中的数据重新存入原数组
        for (int k = 0; k < temp.length; k++) {
            arr[k + low] = temp[k];
        }
    }


    //归并两个有序数组
    public static int[] Merge(int[] num1, int[] num2) {
        if (num1 == null || num1.length == 0)
            return num2;
        if (num2 == null || num2.length == 0)
            return num1;
        //用于存储归并后的临时数组
        int[] res = new int[num1.length + num2.length];
        int i = 0, j = 0, index = 0;
        //遍历两个数组取出小的数字，放入临时数组中
        while (i < num1.length && j < num2.length) {
            if (num1[i] <= num2[j]) {
                res[index++] = num1[i++];
            } else {
                res[index++] = num2[j++];
            }
        }
        //处理多余数据
        while (i < num1.length) {
            res[index++] = num1[i++];
        }
        while (j < num2.length) {
            res[index++] = num2[j++];
        }
        return res;
    }


    public static int[] merge(int[] nums1, int[] nums2, int m, int n) {
        int index1 = m - 1, index2 = n - 1, mergeIndex = m + n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                nums1[mergeIndex--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[mergeIndex--] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {
                nums1[mergeIndex--] = nums1[index1--];
            } else {
                nums1[mergeIndex--] = nums2[index2--];
            }
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4, 7};
        int[] nums2 = {3, 5, 6, 8};
        int[] arr = {2, 3, 5, 1, 4, 6, 9, 7, 0, 8};
        int l = 0;
        int h = 9;
        System.out.println(Arrays.toString(mergeSort(arr, l, h)));
    }

}
