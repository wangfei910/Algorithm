package Algorithm.LeetCode.T0;

/**
 * 最长公共子序列
 *
 * @author: wangfei
 * @date: 2019/6/19 10:21
 */
public class Solution {

    public static int lengthOfLCS(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0)
            return 0;
        return LCS(str1.length() - 1, str2.length() - 1, str1, str2);
    }

    private static int LCS(int m, int n, String str1, String str2) {
        if (str1.charAt(m) == str2.charAt(n)) {
            return LCS(m - 1, n - 1, str1, str2) + 1;
        } else {
            return Math.max(LCS(m - 1, n, str1, str2), LCS(m, n - 1,str1, str2));
        }
    }


    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        String str1 = "abcffgse";
        String str2 = "abcdefgh";
        System.out.println(lengthOfLCS(str1, str2));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
