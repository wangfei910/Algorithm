package Algorithm.LeetCode.T50;

/**
 * 求x的n次方幂
 *
 * @author wangfei
 */
public class Solution {
    /**
     * 利用分治的思想进行递归
     * 1.先判断n小于和等于0的情况
     * 2.将n区分奇数和偶数两种情况分别进行递归运算
     * 时间复杂度为O(NlogN)
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
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        double x = 2.0000;
        int n = -2147483648;
        System.out.println(myPow(x, n));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
