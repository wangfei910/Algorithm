package Algorithm.LeetCode.T438;

import java.util.ArrayList;
import java.util.List;

/**
 * 在一个字符串中找到所有的Anagrams
 * <p>
 * 给定一个字符串s和一个非空字符串p，在s中找到所有p的Anagrams的起始索引。
 * 字符串只由小写英文字母组成，字符串s和p的长度都不大于20,100。
 * 输出的顺序无关紧要。
 *
 * @author: wangfei
 * @date: 2019/5/19 20:32
 */
public class Solution {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length())
            return list;
        int[] chars = new int[256];
        for (Character c : p.toCharArray()) {
            chars[c - 'a']++;
        }
        char temp;
        int start = 0, end = 0;
        int len = p.length(), diff = len;
        for (end = 0; end < len; end++) {
            temp = s.charAt(end);
            chars[temp - 'a']--;
            if (chars[temp - 'a'] >= 0) {
                diff--;
            }
        }
        if (diff == 0) {
            list.add(0);
        }
        while (end < s.length()) {
            temp = s.charAt(start);
            if (chars[temp - 'a'] >= 0) {
                diff++;
            }
            chars[temp - 'a']++;
            start++;
            temp = s.charAt(end);
            chars[temp - 'a']--;
            if (chars[temp - 'a'] >= 0) {
                diff--;
            }
            if (diff == 0) {
                list.add(start);
            }
            end++;
        }
        return list;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }

}
