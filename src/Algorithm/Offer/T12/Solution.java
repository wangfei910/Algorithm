package Algorithm.Offer.T12;

/**
 * 数值的整数次方
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
     * @param base
     * @param exponent
     * @return
     */
    public static double Power(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent < 0) {
            exponent = -exponent;
            base = 1 / base;
            if (-exponent == Integer.MIN_VALUE)
                return base * Power(base, exponent - 1);
        }
        return (exponent % 2 == 0) ? Power(base * base, exponent / 2) : base * Power(base * base, exponent / 2);
    }

    /**
     * for 循环模拟幂运算
     * 注意 exponent 的正负号
     *
     * @param base
     * @param exponent
     * @return
     */
    public static double Power2(double base, int exponent) {
        if (exponent == 0)
            return 1;
        double res = base;
        for (int i = 1; i < Math.abs(exponent); i++) {
            res *= base;
        }
        if (exponent > 0)
            return res;
        else
            return (double) 1 / res;
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
        System.out.println(Power(x, n));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
