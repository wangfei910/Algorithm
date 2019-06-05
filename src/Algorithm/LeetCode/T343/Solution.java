package Algorithm.LeetCode.T343;

/**
 * 整数拆分
 * <p>
 * 给定一个正整数n，将其分解为至少两个正整数的和，并使这些整数的乘积最大化。返回您能得到的最大产品。
 *
 * @author: wangfei
 * @date: 2019/6/4 22:47
 */
public class Solution {

    /**
     * 递归
     *
     * @param n
     * @return
     */
    public static int integerBreak(int n) {
        return breakInteger(n);
    }

    //将数字n进行分割（至少分割成两部分）后得到的最大乘积
    private static int breakInteger(int n) {
        int[] memo = new int[n + 1];
        if (n == 1)
            return 1;
        if (memo[n] != 0)
            return memo[n];
        int res = -1;
        for (int i = 1; i < n; i++) {
            //i + (n - i)
            res = Math.max(res, Math.max((i * (n - i)), i * breakInteger(n - i)));
        }
        memo[n] = res;
        return res;
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public static int integerBreak2(int n) {
        //memo[i]表示将数字i分割（至少分割成两部分）后得到的最大乘积
        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            //求解memo[i]
            for (int j = 1; j <= i - 1; j++) {
                //j + (i - j)
                memo[i] = Math.max(memo[i], Math.max((j * (i - j)), j * memo[i - j]));
            }
        }
        return memo[n];
    }

    public static int integerBreak3(int n) {
        int[] res = new int[n + 1];
        res[1] = 1;
        // For numbers from 2 to 6
        for (int i = 2; i <= 6 && i <= n; i++) {
            res[i] = (int) i / 2 * (i - (int) i / 2);
        }
        // For numbers larger than 6, apply DP.
        for (int i = 7; i <= n; i++) {
            res[i] = Math.max(res[i - 2] * 2, res[i - 3] * 3);
        }
        return res[n];
    }

    /**
     * 给定一个数字n，假设我们有一个可能的乘积P = p1 * p2 *…pk。然后我们注意到将会发生什么
     * 如果我们能把π分成两个术语假设的一个术语是2我们可以得到π2和2如果2(π2)>π我们会得到一个更大的产品,
     * 这种情况如果π> 4。因为还有一个小于4的数不是2，也就是3。同样对于3如果我们把其中一项分解成-3和3
     * 我们会得到一个更大的乘积如果3*(pi-3) >如果> 4。5。因此我们知道乘积中的所有项都必须是2和3。
     *
     * @param n
     * @return
     */
    public static int integerBreak4(int n) {
        if (n == 2)
            return 1;
        else if (n == 3)
            return 2;
        else if (n % 3 == 0)
            return (int) Math.pow(3, n / 3);
        else if (n % 3 == 1)
            return 2 * 2 * (int) Math.pow(3, (n - 4) / 3);
        else
            return 2 * (int) Math.pow(3, n / 3);
    }


    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int n = 10;
        System.out.println(integerBreak2(n));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
