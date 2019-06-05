package Algorithm.LeetCode.T17;

import java.util.HashMap;
import java.util.*;

/**
 * 电话号码的字母组合
 * <p>
 * 给定一个包含2-9个数字的字符串，返回该数字可能表示的所有字母组合。
 * 下面给出了数字到字母的映射(就像电话按钮一样)。注意，1不映射到任何字母。
 *
 * @author: wangfei
 * @date: 2019/5/30 19:42
 */
public class Solution {

    private static String[] letterMap = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private static List<String> res = new LinkedList<>();

    /**
     * 递归 + 回溯
     * 时间复杂度：O(2^n)
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        if (digits.equals(""))
            return res;
        findCombination(digits, 0, "");
        return res;
    }

    /**
     * s中保存了此时从 c[0...index-1] 翻译得到的每一个字母字符串
     * 寻找和 c[index] 匹配的字母，获得 c[0...index] 翻译得到的解
     *
     * @param digits
     * @param index
     * @param s
     */
    private static void findCombination(String digits, int index, String s) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        char[] c = digits.toCharArray();
        if (c[index] >= '0' && c[index] <= '9' && c[index] != '1') {
            String letters = letterMap[c[index] - '0'];
            char[] letter = letters.toCharArray();
            for (int i = 0; i < letter.length; i++) {
                findCombination(digits, index + 1, s + letter[i]);
            }
        }
        return;
    }


    public List<String> letterCombinations2(String digits) {
        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List<String> ret = new ArrayList<>();
        if (digits.equals("")) {
            return ret;
        }
        dfs(digits, 0, "", map, ret);
        return ret;
    }

    private void dfs(String digits, int idx, String path, Map<Character, String> map, List<String> ret) {
        if (digits.length() == path.length()) {
            ret.add(path);
            return;
        }
        for (int i = idx; i < digits.length(); i++) {
            for (char c : map.get(digits.charAt(i)).toCharArray()) {
                dfs(digits, i + 1, path + c, map, ret);
            }
        }
    }


    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        String digits = "";
        System.out.println(letterCombinations(digits));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
