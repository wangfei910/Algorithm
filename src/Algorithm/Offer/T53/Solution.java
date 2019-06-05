package Algorithm.Offer.T53;

/**
 * 表示数值的字符串
 * <p>
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * @author: wangfei
 * @date: 2019/5/12 21:01
 */
public class Solution {

    /**
     * 1、()标记一个子表达式的开始和结束位置，分组
     * 2、* 匹配前面的子表达式零次或者多次
     * 3、+ 匹配前面的子表达式一次或者多次
     * 4、? 匹配前面的子表达式零次或者一次
     * 5、[] 字符集合
     * 6、\\. 转义后
     * 7、\\d 数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}
