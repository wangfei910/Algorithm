package Algorithm.LeetCode.T76;

/**
 * 最小的窗口子串
 * <p>
 * 给定一个字符串S和一个字符串T，找出S中的最小窗口，该窗口将包含复杂度为O(n)的T中的所有字符。
 * 注意：
 * （1）如果S中没有覆盖T中所有字符的窗口，则返回空字符串""。
 * （2）如果存在这样的窗口，则可以保证在S中始终只有一个惟一的最小窗口。
 *
 * @author: wangfei
 * @date: 2019/5/19 20:30
 */
public class Solution {

    public static String minWindows(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return "";

        return "";
    }


    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        String s = "bbbbb";
        String t = "";
        System.out.println(minWindows(s, t));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
