package Algorithm.LeetCode.T455;

import java.util.Arrays;

/**
 * 分配饼干
 *
 * @author: wangfei
 * @date: 2019/4/17 11:19
 */
public class Solution {

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int si = 0, gi = 0;
        while (si < s.length && gi < g.length) {
            if (g[gi] <= s[si]){
                gi++;
            }
            si++;
        }
        return gi;
    }


    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] g = {1, 2, 2, 3, 4};
        int[] s = {1, 2, 3, 2, 3};
        System.out.println(findContentChildren(g, s));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
