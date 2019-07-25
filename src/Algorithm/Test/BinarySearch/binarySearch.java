package Algorithm.Test.BinarySearch;

/**
 * 二分查找
 *
 * @author: wangfei
 * @date: 2019/5/18 15:50
 */
public class binarySearch {

    /**
     * 递归
     * 时间复杂度为 O(logN)
     * 只进行一次递归调用中时间复杂度 = 每个递归函数的时间复杂度T * 递归总深度depth
     *
     * @param arr
     * @param l
     * @param r
     * @param target
     * @return
     */
    public int binarySearch1(int[] arr, int l, int r, int target) {
        if (l > r)
            return -1;
        int mid = l + (r - l) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearch1(arr, l, mid - 1, target);
        } else {
            return binarySearch1(arr, mid + 1, r, target);
        }
    }

    /**
     * 非递归(闭区间)
     *
     * @param arr
     * @param n
     * @param target
     * @return
     */
    public int binarySearch2(int[] arr, int n, int target) {
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 非递归(前闭后开)
     *
     * @param arr
     * @param n
     * @param target
     * @return
     */
    public int binarySearch3(int[] arr, int n, int target) {
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return -1;
    }
}
