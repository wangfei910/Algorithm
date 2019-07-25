package Algorithm.Test.T8;

import java.util.Scanner;

/**
 * 最长公共子串
 *
 * @author: wangfei
 * @date: 2019/6/3 20:58
 */
public class Solution {

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String maxSubString = getSubString(s1, s2);
        System.out.println(maxSubString);
    }

    /**
     * 首先判断两个字符串的长度，再比较短字符串是否包含在长字符串里；
     * 若包含直接返回段字符串，若不包含则缩减短字符串再进行比较；
     * 用到substring（start,end）方法，依次缩减字符串；
     *
     * @param s1
     * @param s2
     * @return
     */
    public static String getSubString(String s1, String s2) {
        //第一步判断两个字符串长度
        String minStr = (s1.length() < s2.length()) ? s1 : s2;
        String maxStr = minStr.equals(s1) ? s2 : s1;
        System.out.println(minStr);
        System.out.println(maxStr);
        for (int i = 0; i < minStr.length(); i++) {
            for (int start = 0, end = minStr.length() - i; end <= minStr.length(); start++, end++) {
                String temp = minStr.substring(start, end);
                if (maxStr.contains(temp)) {
                    return temp;
                }
            }
        }
        return null;
    }

}

