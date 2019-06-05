package Algorithm.LeetCode.T231;

/**
 * Power of Two
 *
 * @author: wangfei
 * @date: 2019/4/2 17:03
 */
public class Solution {

    /**
     * int的最大值是2^31-1，用Math.pow(2,31)(double)对n取余数。
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && Math.pow(2, 31) % n == 0;
    }

    public static boolean isPowerOfTwo1(int n) {
        return n > 0 && (Math.log10(n) / Math.log10(2)) % 1 == 0;
    }

    public static boolean isPowerOfTwo2(int n) {
        if (n <= 0)
            return false;
        return (n & (n - 1)) == 0;
    }

    /**
     * 2的幂表示n中只有一位是1，只要数一数“1”位的个数
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo3(int n) {
        if (n < 0)
            return false;
        return Integer.bitCount(n) == 1;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int n = 1024;
        System.out.println(isPowerOfTwo3(n));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
