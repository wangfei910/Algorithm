package Algorithm.Offer.T52;

/**
 * 正则表达式匹配
 * <p>
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 * @author: wangfei
 * @date: 2019/5/12 20:44
 */
public class Solution {

    /**
     * 1、基本思想：从前向后，维护两个指针（一个指针遍历 S，一个指针遍历 P，并不断判断当前两指针的子串是否匹配）。
     * 利用一个 boolean[s.length+1][p.length+1] 来表示，dp[i][j] 表示，若 S 的子串 [0, i-1] 和 P 的子串 [0, j-1]
     * 相匹配为 true，不匹配则为 false，以下表中 dp[4][3] = 1为例子，表示 aa 和 ab*a 相匹配。
     * 由于 dp[0][0] 表示 P 和 S 均为空串，则 P[i - 1] 表示当前字符
     * <p>
     * 2、填充数组第一行：S 为空串，若要匹配
     * （1）P 为空串
     * （2）P 为 x*y* 形式， P[i - 1] == * 时，dp[0][i] = dp[0][i - 2]
     * <p>
     * 3、填充剩下的部分：每次 S 字符往下走一个字符，然后和所有的 P 子串匹配
     * （1）P[i - 1] != *：P 和 S 的字符相等，或者 P 的字符为 .
     * （2）P[i - 1] == *：[1] * 代表空串 [2] * 代表对前一个字符串的复制（0 或多个）
     * <p>
     * 4、动态规划表 | S\P | "" | a | b | * | a | c | * | a | | :--: | :-----: | :-----: | :-----: | :-----:
     * | :-----: | :-----: | :-----: | :-----: | | "" | 1 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | | a | 0 | 1 | 0 | 1
     * | 0 | 0 | 0 | 0 | | a | 0 | 0 | 0 | 0 | 1 | 0 | 1 | 0 | | a | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 1 |
     *
     * @param str
     * @param pattern
     * @return
     */
    public static boolean match(char[] str, char[] pattern) {
        int m = str.length;
        int n = pattern.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (pattern[i - 1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
                        //匹配 0 个
                        dp[i][j] |= dp[i][j - 2];
                        //匹配 1 个
                        dp[i][j] |= dp[i][j - 1];
                        //匹配多个
                        dp[i][j] |= dp[i - 1][j];
                    } else {
                        //仅匹配 0 个
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
