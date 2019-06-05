package Algorithm.LeetCode.T205;

/**
 * 同构的字符串
 * <p>
 * 给定两个字符串s和t，判断它们是否同构。
 * 如果可以将s中的字符替换为t，则两个字符串是同构的。
 * 必须用另一个字符替换出现的所有字符，同时保留字符的顺序。没有两个字符可以映射到同一个字符，但是一个字符可以映射到它自己。
 *
 * @author: wangfei
 * @date: 2019/5/21 13:38
 */
public class Solution {

    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length())
            return false;

        return true;
    }
}
