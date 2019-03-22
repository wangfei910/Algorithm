package Algorithm.Offer.T1;

/**
 * 二维数组中的查找
 *
 * @author wangfei
 */
public class Solution {
    /**
     * 把每一行看成有序递增的数组，利用二分查找，通过遍历每一行得到答案.
     * 时间复杂度是O(NlogN)
     *
     * @param target
     * @param array
     * @return
     */
    public static boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0)
            return false;
        for (int i = 0; i < array.length; i++) {
            int low = 0;
            int high = array[i].length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (target > array[i][mid])
                    low = mid + 1;
                else if (target < array[i][mid])
                    low = mid - 1;
                else
                    return true;
            }
        }
        return false;
    }


    /**
     * 1.利用二维数组由上到下，由左到右递增的规律，那么选取右上角或者左下角的元素a[row][col]与target进行比较，
     * 2.当target小于元素a[row][col]时，那么target必定在元素a所在行的左边,即col--；
     * 3.当target大于元素a[row][col]时，那么target必定在元素a所在列的下边,即row++；
     *
     * @param target
     * @param array
     * @return
     */
    public static boolean Find2(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0)
            return false;
        int row = 0;
        int col = array[0].length - 1;
        while (row <= array.length - 1 && col >= 0) {
            if (target == array[row][col])
                return true;
            else if (target > array[row][col])
                row++;
            else
                col--;
        }
        return false;
    }


    public static void main(String[] args) {
        long start = System.nanoTime();
        int[][] array = {{1, 2, 3, 4, 5, 6, 7, 8, 9}, {11, 12, 13, 14, 15, 16, 17, 18, 19}, {21, 22, 23, 24, 25, 26, 27, 28, 29}};
        int target = 6;
        System.out.println(Find2(target, array));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
