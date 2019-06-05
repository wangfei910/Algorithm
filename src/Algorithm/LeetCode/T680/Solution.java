package Algorithm.LeetCode.T680;

/**
 * 回文字符串
 *
 * @author: wangfei
 * @date: 2019/4/8 20:40
 */
public class Solution {

    /**
     * 最多可以删除一个字符，判断是否能构成回文字符串。
     *
     * @param s
     * @return
     */
    public static boolean validPalindrome(String s) {
        int i = -1, j = s.length();
        while (++i < --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
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
        long start = System.currentTimeMillis();
        String s = "abcda";
        System.out.println(validPalindrome(s));
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start) + "ms");
    }

}
