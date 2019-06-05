package Algorithm.LeetCode.T763;

import java.util.ArrayList;
import java.util.List;

/**
 * 分隔字符串使同种字符出现在一起
 *
 * @author: wangfei
 * @date: 2019/4/21 21:32
 */
public class Solution {

    public static List<Integer> partitionLabels(String S) {
        int[] lastIndexsOfChar = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndexsOfChar[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partitions = new ArrayList<>();
        int firstIndex = 0;
        while (firstIndex < S.length()) {
            int lastIndex = firstIndex;
            for (int i = firstIndex; i < S.length() && i <= lastIndex; i++) {
                int index = lastIndexsOfChar[S.charAt(i) - 'a'];
                if (index > lastIndex) {
                    lastIndex = index;
                }
            }
            partitions.add(lastIndex - firstIndex + 1);
            firstIndex = lastIndex + 1;
        }
        return partitions;
    }


    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        String S = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(S));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
