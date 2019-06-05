package Algorithm.Offer.T47;

/**
 * 求1+2+3+...+n
 * <p>
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * @author: wangfei
 * @date: 2019/5/11 18:46
 */
public class Solution {

    /**
     * 1、&& 具有短路原则，即在第一个条件语句为 false 的情况下不会去执行第二个条件语句
     * 2、递归终止条件取非作为 && 的第一个语句，递归的主体转换作为第二个条件语句
     * 3、当递归的返回条件为 true 的情况下就不会执行递归的主体部分，递归返回
     *
     * @param n
     * @return
     */
    public static int Sum(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += Sum(n - 1)) > 0);
        return sum;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int n = 10;
        System.out.println(Sum(n));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
