package Algorithm.Offer.T6;

/**
 * 旋转数组的最小数字
 *
 * @author wangfei
 */
public class Solution {
    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0)
            return 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[i + 1])
                return array[i + 1];
        }
        return array[0];
    }

    /**
     * 二分查找
     * mid > right：最小值位于数组右半部分
     * mid < right：最小值位于数组左半部分
     * mid = right：最小值位于当下数组中，且数组左右端点值相等，存在重复值，依次寻找
     *
     * @param array
     * @return
     */
    public static int minNumberInRotateArray2(int[] array) {
        if (array.length == 0)
            return 0;
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] > array[right])
                left = mid + 1;
            else if (array[mid] < array[right])
                right = mid;
            else
                left = left + 1;
        }
        return array[left];
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] array = new int[]{3, 4, 5, 6, 7, 2, 8, 9};
        System.out.println(minNumberInRotateArray(array));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
