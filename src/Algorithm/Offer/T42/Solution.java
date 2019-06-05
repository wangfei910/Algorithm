package Algorithm.Offer.T42;

import java.util.ArrayList;

/**
 * 和为 S 的两个数字
 * <p>
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * @author: wangfei
 * @date: 2019/5/9 19:15
 */
public class Solution {

    /**
     * 双指针
     * 1、low 指针为最左边，high 指针为最右边，totalSum 记录两个指针指向的数组数字和
     * 2、如果 totalSum 比 sum 小，则 low 左移；如果 totalSum 比 sum 大，则 high 右移
     *
     * @param array
     * @param sum
     * @return
     */
    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> resList = new ArrayList<>();
        if (array == null)
            return resList;
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int totalSum = array[low] + array[high];
            if (totalSum > sum) {
                high--;
            } else if (totalSum < sum) {
                low++;
            } else {
                resList.add(array[low]);
                resList.add(array[high]);
                break;
            }
        }
        return resList;
    }

    /**
     * 二分查找
     * 1、遍历数组，依次取得第一个数 A
     * 2、二分查找剩下元素中是否存在 S - A
     * 3、存在多组数据则输出乘积最小的，此处利用数学方法，和相等，差值越大的两个数乘积越小，因此找到的第一组数据就是所求结果
     *
     * @param array
     * @param sum
     * @return
     */
    public static ArrayList<Integer> FindNumbersWithSum2(int[] array, int sum) {
        ArrayList<Integer> resList = new ArrayList<>();
        if (array == null)
            return resList;
        for (int i = 0; i < array.length - 1; i++) {
            int res = BinarySearch(array, i, array.length, sum - array[i]);
            if (array[res] != (sum - array[i])) {
                continue;
            }else {
                resList.add(array[i]);
                resList.add(array[res]);
                break;
            }
        }
        return resList;
    }

    private static int BinarySearch(int[] array, int low, int high, int target) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target > array[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] array = {1, 2, 4, 7, 11, 16};
        int sum = 17;
        System.out.println(FindNumbersWithSum2(array, sum));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
