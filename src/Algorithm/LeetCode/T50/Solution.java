package Algorithm.LeetCode.T50;

/**
 * 求x的n次方幂
 *
 * @author wangfei
 */
public class Solution {
    /**
     * 利用分治的思想进行递归
     * 1.先判断 n 小于和等于 0 的情况
     * 2.将 n 区分奇数和偶数两种情况分别进行递归运算
     * 时间复杂度为 O(NlogN)
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
            if (-n == Integer.MIN_VALUE) {
                return x * myPow(x, (n - 1));
            }
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

    /**
     * 暴力解法 O(N)
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow2(double x, int n) {
        double res = 1;
        if (n < 0) {
            x = 1 / x;
            n = -n;
            if (n == Integer.MIN_VALUE) {
                n = -(n + 1);
            }
        }
        while (n != 0) {
            res *= x;
            n--;
        }
        return res;
    }

    /**
     * 位运算
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow3(double x, int n) {
        double res = 1;
        if (n < 0) {
            x = 1 / x;
            n = -n;
            if (n == Integer.MIN_VALUE) {
                n = -(n + 1);
            }
        }
        while (n != 0) {
            if ((n & 1) == 1) {
                res *= x;
            }
            x *= x;
            n >>= 1;
        }
        return res;
    }


    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        double x = 2.0000;
        int n = -2147483648;
        System.out.println(myPow3(x, n));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
