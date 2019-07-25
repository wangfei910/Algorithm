package Algorithm.Test.Sort;

/**
 * 插入排序（近乎有序的数组性能更高）
 * 时间复杂度：O(N^2)
 *
 * @author: wangfei
 * @date: 2019/5/25 23:37
 */
public class Insertion_Sort {

    public static void insertSort(int[] arr) {
        //遍历除第一个元素之外的所有元素
        for (int i = 1; i < arr.length; i++) {
            //把当前遍历元素存起来
            int temp = arr[i];
            int j;
            //遍历当前元素前面所有的元素
            for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                //把前一个元素赋给后一个元素
                arr[j + 1] = arr[j];
            }
            //把临时变量（外层for循环的当前元素）赋给不满足条件的后一个元素
            arr[j + 1] = temp;
        }
    }
}
