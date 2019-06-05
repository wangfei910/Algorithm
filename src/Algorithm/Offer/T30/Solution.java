package Algorithm.Offer.T30;

/**
 * 连续子数组的最大和
 * <p>
 * {6, -3, -2, 7, -15, 1, 2, 2}，连续子数组的最大和为 8（从第 0 个开始，到第 3 个为止）
 *
 * @author: wangfei
 * @date: 2019/5/5 21:16
 */
public class Solution {

    public static int FindGreatestSumOfArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int arr : array) {
            sum = sum <= 0 ? arr : sum + arr;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] array = {1, 2, -3, 2, -2, 2, -5, 4, 2};
        System.out.println(FindGreatestSumOfArray(array));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
