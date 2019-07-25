package Algorithm.Test.T4;

import java.util.Scanner;

/**
 * 大小端
 *
 * @author: wangfei
 * @date: 2019/4/5 17:25
 */
public class Solution {

    /**
     * 三者在执行速度方面的比较：StringBuilder >  StringBuffer  >  String
     *
     * String：字符串常量
     * StringBuffer：字符串变量
     * StringBuilder：字符串变量
     *
     * 1.如果要操作少量的数据用 = String
     * 2.单线程操作字符串缓冲区 下操作大量数据 = StringBuilder
     * 3.多线程操作字符串缓冲区 下操作大量数据 = StringBuffer
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            String str1 = in.next();
            int i = 0;
            StringBuilder sb = new StringBuilder();
            while (i < str1.length()) {
                if (str1.charAt(i) == '0') {
                    for (int k = i + 8; k > i; k--) {
                        sb.append(str1.charAt(k));
                    }
                    sb.append(" ");
                } else if (str1.charAt(i) == '1') {
                    for (int k = i + 1; k <= i + 8; k++) {
                        sb.append(str1.charAt(k));
                    }
                    sb.append(" ");
                }
                i += 9;
            }
            System.out.println(sb.toString().trim());
        }
    }
}
