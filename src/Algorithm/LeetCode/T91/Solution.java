package Algorithm.LeetCode.T91;

/**
 * 解码方法
 * <p>
 * 载有字母A- z的讯息正使用以下映射编码成数字:
 * A - > 1
 * “B”- > 2
 * …
 * “Z”- > 26
 * 给定一个只包含数字的非空字符串，确定解码它的方法的总数。
 *
 * @author: wangfei
 * @date: 2019/6/6 9:04
 */
public class Solution {

    private static int res = 0;

    public static int numDecodings(String s) {
        char[] arr = s.toCharArray();
        DFS(arr, 0);
        return res;
    }

    private static void DFS(char[] arr, int index) {
        if (index == arr.length) {
            res++;
            return;
        }
        if (arr[index] != '0') {
            DFS(arr, index + 1);
        }
        if (index <= arr.length - 2 && (arr[index] == '1' || (arr[index] == '2' && arr[index + 1] - '6' <= 0))) {
            DFS(arr, index + 2);
        }
    }

    /**
     * 动态规划
     * <p>
     * 我使用了一个大小为n + 1的dp数组来保存子问题的解决方案。dp[0]表示空字符串只有一种解码方式，
     * dp[1]表示解码大小为1的字符串的方式。然后检查一位数和两位数的组合并保存结果。最终的结果是dp[n]。
     *
     * @param s
     * @return
     */
    public static int numDecodings2(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public static int numDecodings3(String s) {
        int n = s.length();
        if (n == 0) {
            return 1;
        }
        int secondPrev = 1;
        int prev = s.charAt(n - 1) == '0' ? 0 : 1;
        for (int i = n - 2; i >= 0; i--) {
            char c = s.charAt(i);
            int oldPrev = prev;
            int currentResult = c != '0' ? prev : 0;
            int num = (c - '0') * 10 + s.charAt(i + 1) - '0';
            if (c != '0' && num <= 26) {
                currentResult += secondPrev;
            }
            prev = currentResult;
            secondPrev = oldPrev;
        }
        return prev;
    }

    public static int numDecodings4(String s) {
        int n = s.length();
        if (n == 0)
            return 0;
        int[] memo = new int[n + 1];
        memo[n] = 1;
        memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') {
                continue;
            } else {
                memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];
            }
        return memo[0];
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        String s = "12";
        System.out.println(numDecodings4(s));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }

}
