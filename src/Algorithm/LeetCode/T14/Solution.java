package Algorithm.LeetCode.T14;

/**
 * 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中最长的公共前缀字符串。
 * 如果没有公共前缀，返回一个空字符串“”。
 *
 * @author: wangfei
 * @date: 2019/6/19 10:50
 */
public class Solution {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        StringBuilder pre = new StringBuilder(strs[0]);
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < pre.length(); j++) {
                if (j >= strs[i].length() || pre.charAt(j) != strs[i].charAt(j)) {
                    pre.delete(j, pre.length());
                    break;
                }
            }
        }
        return pre.toString();
    }


    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        int index = prefix.length();
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < index; j++) {
                if (j >= strs[i].length() || prefix.charAt(j) != strs[i].charAt(j)) {
                    index = j;
                    break;
                }
            }
        }
        return prefix.substring(0, index);
    }


    public static String longestCommonPrefix3(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        int shortest = 0;
        int len = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            int curLen = strs[i].length();
            if (curLen < len) {
                len = curLen;
                shortest = i;
            }
        }
        String sub = strs[shortest];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(sub) != 0) {
                sub = sub.substring(0, sub.length() - 1);
            }
        }
        return sub;
    }


    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix3(strs));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
