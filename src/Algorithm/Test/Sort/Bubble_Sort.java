package Algorithm.Test.Sort;

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
    public static void bubbleSort(int[] arr) {
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
    }

}
