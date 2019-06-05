package Algorithm.LeetCode.T242;

import java.util.HashMap;

/**
 * 有效的回文构词法
 *
 * @author wangfei
 */
public class Solution {

    /**
     * 将26个小写字母映射到长度为26的数组中去，s字符串中存在某个字母时对应位置的数组中加1，
     * t字符串中存在某个字母时对应位置的数组中减1，最后遍历数组元素，若存在不为0的数组值，
     * 则返回false,否则返回true
     * 时间复杂度为O(N)
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() != t.length())
            return false;
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for (int i : arr) {
            if (i != 0)
                return false;
        }
        return true;
    }

    /**
     * 时间复杂度：O(nlogn)
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t) {
        if (s == null || t == null || s.length() != t.length())
            return false;
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (count.containsKey(s.charAt(i))) {
                count.put(s.charAt(i), count.get(s.charAt(i)) + 1);
            } else {
                count.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (count.containsKey(t.charAt(i)) && count.get(t.charAt(i)) > 0) {
                count.put(t.charAt(i), count.get(t.charAt(i)) - 1);
            }
        }
        for (int i : count.values()) {
            if (i != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram2(s, t));
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start) + "ms");
    }

}
