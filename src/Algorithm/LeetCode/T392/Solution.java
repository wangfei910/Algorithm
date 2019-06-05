package Algorithm.LeetCode.T392;

/**
 * 判断是否为子序列
 * <p>
 * 给定一个字符串s和一个字符串t，检查s是否是t的子序列。
 * 您可以假设在s和t中都只有小写的英文字母，t可能是一个非常长的(长度~= 500,000)字符串，而s是一个短字符串(<=100)。
 * 一个字符串的子序列是一个新的字符串，它由原来的字符串组成，删除一些字符(可以是none)，而不影响其余字符的相对位置。
 * (例如，“ace”是“abcde”的子序列，而“aec”不是)。
 *
 * @author: wangfei
 * @date: 2019/4/21 22:28
 */
public class Solution {

    public static boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            //indexOf是查找字符串或者子串第一次出现的地方
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
