package Algorithm.Offer.T37;

/**
 * 数字在排序数组中出现的次数
 *
 * @author: wangfei
 * @date: 2019/5/8 20:45
 */
public class Solution {

    public static int GetNumberOfK(int[] array, int k) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k)
                count++;
        }
        return count;
    }


    public static int GetNumberOfK2(int[] array, int k) {
        int l = 0, h = array.length - 1;
        while (l < h) {
            if (array[l] != k) {
                l++;
            } else if (array[h] != k) {
                h--;
            }
            if (array[l] == k && array[h] == k) {
                break;
            }
        }
        return (l == array.length - 1 && array[l] != k) ? 0 : h - l + 1;
    }

    public int GetNumberOfK3(int[] array, int k) {
        int length = array.length;
        if (length == 0) {
            return 0;
        }
        int firstK = getFirstK(array, k, 0, length - 1);
        int lastK = getLastK(array, k, 0, length - 1);
        if (firstK != -1 && lastK != -1) {
            return lastK - firstK + 1;
        }
        return 0;
    }

    //递归写法
    private int getFirstK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) >> 1;
        if (array[mid] > k) {
            return getFirstK(array, k, start, mid - 1);
        } else if (array[mid] < k) {
            return getFirstK(array, k, mid + 1, end);
        } else if (mid - 1 >= 0 && array[mid - 1] == k) {
            return getFirstK(array, k, start, mid - 1);
        } else {
            return mid;
        }
    }

    //循环写法
    private int getLastK(int[] array, int k, int start, int end) {
        int length = array.length;
        int mid = (start + end) >> 1;
        while (start <= end) {
            if (array[mid] > k) {
                end = mid - 1;
            } else if (array[mid] < k) {
                start = mid + 1;
            } else if (mid + 1 < length && array[mid + 1] == k) {
                start = mid + 1;
            } else {
                return mid;
            }
            mid = (start + end) >> 1;
        }
        return -1;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] array = {1, 3, 3, 3, 3, 4, 5};
        int k = 2;
        System.out.println(GetNumberOfK2(array, k));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
