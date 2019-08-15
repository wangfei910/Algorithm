package Algorithm.LeetCode.T151;

/**
 * @author: wangfei
 * @date: 2019/8/11 20:35
 */
public class Solution {
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return "";
        char[] chars = s.toCharArray();
        int index = 0;
        while (index < s.length()) {
            int start = index, end = index;
            while (chars[end] != ' ' && end != s.length() - 1)
                end++;
            if (end < s.length() - 1) {
                reverse(chars, start, end - 1);
                index = end + 1;
            } else {
                reverse(chars, start, end);
                break;
            }
        }
        reverse(chars, 0, s.length() - 1);
        return String.valueOf(chars);
    }

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            swap(chars, start++, end--);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }
}
