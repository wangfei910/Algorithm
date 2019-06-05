package Algorithm.Offer.T49;

/**
 * 把字符串转换成整数
 * <p>
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 *
 * @author: wangfei
 * @date: 2019/5/11 19:23
 */
public class Solution {

    public static int StrToInt(String str) {
        if (str == null || str.length() == 0)
            return 0;
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-'))
                continue;
            if (c < '0' || c > '9')
                return 0;
            res = res * 10 + (c - '0');
        }
        return str.charAt(0) == '-' ? -res : res;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        String str = "-2147483647";
        System.out.println(StrToInt(str));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
