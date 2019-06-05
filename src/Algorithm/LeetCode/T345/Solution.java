package Algorithm.LeetCode.T345;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 反转字符串的元音字符
 *
 * @author: wangfei
 * @date: 2019/4/8 20:02
 */
public class Solution {

    private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    /**
     * 使用双指针指向待反转的两个元音字符，一个指针从头向尾遍历，一个指针从尾到头遍历。
     *
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] chars = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)) {
                chars[i++] = ci;
            } else if (!vowels.contains(cj)) {
                chars[j--] = cj;
            } else {
                chars[i++] = cj;
                chars[j--] = ci;
            }
        }
        return new String(chars);
    }

    public static String reverseVowels1(String s) {
        if (s == null || s.length() == 0)
            return s;
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            while (i < j && !vowels.contains(chars[i] + "")){
                i++;
            }
            while (i < j && !vowels.contains(chars[j] + "")){
                j--;
            }
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    public static String reverseVowels2(String s) {
        if (s == null || s.length() == 0)
            return s;
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(chars[i] + "")) {
                chars[i++] = ci;
            } else if (!vowels.contains(chars[j] + "")) {
                chars[j--] = cj;
            } else {
                chars[i++] = cj;
                chars[j--] = ci;
            }
        }
        return new String(chars);
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String s = "abcdefgh";
        System.out.println(reverseVowels2(s));
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start) + "ms");
    }
}
