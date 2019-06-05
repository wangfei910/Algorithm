package Algorithm.LeetCode.T125;

/**
 * 有效的回文
 * <p>
 * 给定一个字符串,确定它是否是一个回文序列,考虑到只有字母数字字符并且忽略大小写。
 * 注意:为了这个问题的目的,我们定义空字符串作为有效的palindrome。
 *
 * @author: wangfei
 * @date: 2019/5/19 16:01
 */
public class Solution {

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l <= r) {
            if ((chars[l] < 'a' || chars[l] > 'z') && (chars[l] < '0' || chars[l] > '9') && (chars[l] < 'A' || chars[l] > 'Z')) {
                l++;
            } else if ((chars[r] < 'a' || chars[r] > 'z') && (chars[r] < '0' || chars[r] > '9') && (chars[r] < 'A' || chars[r] > 'Z')) {
                r--;
            } else if (chars[l] == chars[r] || chars[l] + 32 == chars[r] || chars[l] - 32 == chars[r]) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }


    public static boolean isPalindrome2(String s) {
        if (s == null || s.length() == 0)
            return true;
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            char head = s.charAt(l);
            char tail = s.charAt(r);
            if (!Character.isLetterOrDigit(head)) {
                l++;
            } else if (!Character.isLetterOrDigit(tail)) {
                r--;
            } else {
                if (Character.toLowerCase(head) != Character.toLowerCase(tail)) {
                    return false;
                }
                l++;
                r--;
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
        String s = "0P";
        System.out.println(isPalindrome(s));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
