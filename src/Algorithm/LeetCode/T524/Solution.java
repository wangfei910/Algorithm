package Algorithm.LeetCode.T524;

import java.util.Collections;
import java.util.List;

/**
 * 最长子序列
 *
 * @author: wangfei
 * @date: 2019/4/8 21:54
 */
public class Solution {

    /**
     * 删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，
     * 找出能构成的最长字符串。如果有多个相同长度的结果，返回字典序的最小字符串。
     *
     * @param s
     * @param d
     * @return
     */
    public static String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String target : d) {
            int l1 = longestWord.length(), l2 = target.length();
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if (isValid(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }

    private static boolean isValid(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }

    public String findLongestWord1(String s, List<String> d) {
        String longest = "";
        for (String dictWord : d) {
            int i = 0;
            for (char c : s.toCharArray())
                if (i < dictWord.length() && c == dictWord.charAt(i)) {
                    i++;
                }
            if (i == dictWord.length() && dictWord.length() >= longest.length()) {
                if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0) {
                    longest = dictWord;
                }
            }
        }
        return longest;
    }

    public String findLongestWord2(String s, List<String> d) {
        Collections.sort(d, (a, b) -> a.length() != b.length() ? -Integer.compare(a.length(), b.length()) : a.compareTo(b));
        for (String dictWord : d) {
            int i = 0;
            for (char c : s.toCharArray()) {
                if (i < dictWord.length() && c == dictWord.charAt(i)) {
                    i++;
                }
            }
            if (i == dictWord.length()) {
                return dictWord;
            }
        }
        return "";
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        String s = "abpcplea";
//        List<String> d = ["ale", "apple", "monkey", "plea"];
//        System.out.println(findLongestWord(s, d));
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start) + "ms");
    }
}
