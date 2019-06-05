package Algorithm.LeetCode.T3;

/**
 * 最长的不重复子字符串
 * <p>
 * 给定一个字符串，在不重复字符的情况下找出最长子字符串的长度。
 *
 * @author: wangfei
 * @date: 2019/5/19 20:16
 */
public class Solution {

    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        //将所有字符对应为数组中相应位置并赋初值为0
        int[] freq = new int[256];
        char[] c = s.toCharArray();
        int l = 0, r = -1;
        int res = 0;
        while (l < c.length) {
            if (r + 1 < c.length && freq[c[r + 1]] == 0) {
                r++;
                freq[c[r]]++;
            } else {
                freq[c[l]]--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
