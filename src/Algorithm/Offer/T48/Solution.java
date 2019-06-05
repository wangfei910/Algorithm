package Algorithm.Offer.T48;

/**
 * 不用加减乘除做加法
 * <p>
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * @author: wangfei
 * @date: 2019/5/11 19:00
 */
public class Solution {

    /**
     * 位运算
     *
     * @param num1
     * @param num2
     * @return
     */
    public static int Add(int num1, int num2) {
        return num2 == 0 ? num1 : Add(num1 ^ num2, (num1 & num2) << 1);
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int num1 = 7;
        int num2 = 9;
        System.out.println(Add(num1, num2));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
