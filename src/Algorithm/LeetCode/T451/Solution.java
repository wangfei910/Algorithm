package Algorithm.LeetCode.T451;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 按照字符出现次数对字符串排序（递减排序）
 *
 * @author: wangfei
 * @date: 2019/4/16 14:55
 */
public class Solution {

    /**
     * 设置若干个桶，每个桶存储出现频率相同的字符，并且桶的下标代表桶中字符出现的频率，
     * 即第 i 个桶中存储的字符出现的频率为 i。
     * 把字符串的字符都放到桶之后，从后向前遍历桶并打印输出。
     *
     * @param s
     * @return
     */
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (char c : map.keySet()) {
            int f = map.get(c);
            if (buckets[f] == null) {
                buckets[f] = new ArrayList<>();
            }
            buckets[f].add(c);
        }
        StringBuilder str = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] == null) {
                continue;
            }
            for (char c : buckets[i]) {
                for (int j = 0; j < i; j++) {
                    str.append(c);
                }
            }
        }
        return str.toString();
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String s = "bbaaaccdddeff";
        System.out.println(frequencySort(s));
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start) + "ms");
    }
}
