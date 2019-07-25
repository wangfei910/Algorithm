package Algorithm.Test.Knapsack01;

/**
 * @author: wangfei
 * @date: 2019/6/6 11:01
 */
public class knapsack01 {

    /**
     * 递归
     *
     * @param w
     * @param v
     * @param c
     * @return
     */
    public static int knapsack01(int[] w, int[] v, int c) {
        int n = w.length;
        return bestValue(w, v, n - 1, c);
    }

    //用[0...index]的物品填充容积为c的背包的最大价值
    private static int bestValue(int[] w, int[] v, int index, int c) {
        if (index < 0 || c <= 0)
            return 0;
        int[][] memo = new int[w.length][c + 1];
        if (memo[index][c] != 0)
            return memo[index][c];
        int res = bestValue(w, v, index - 1, c);
        if (c >= w[index]) {
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));
        }
        memo[index][c] = res;
        return res;
    }

    /**
     * DP
     * 时间复杂度：O(n * c)
     * 空间复杂度：O(c)
     *
     * @param w
     * @param v
     * @param c
     * @return
     */
    public static int knapsack012(int[] w, int[] v, int c) {
        int n = w.length;
        if (n == 0 || c == 0)
            return 0;
//        int[][] memo = new int[n][c + 1];
        //空间复杂度优化为 O(c)
        int[][] memo = new int[2][c + 1];
        for (int i = 0; i <= c; i++) {
            memo[0][i] = (i >= w[0] ? v[0] : 0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= c; j++) {
                memo[i % 2][j] = memo[(i - 1) % 2][j];
                if (j >= w[i]) {
                    memo[i % 2][j] = Math.max(memo[i % 2][j], v[i] + memo[(i - 1) % 2][j - w[i]]);
                }
            }
        }
        return memo[(n - 1) % 2][c];
    }

    public static int knapsack013(int[] w, int[] v, int c) {
        int n = w.length;
        if (n == 0 || c == 0)
            return 0;
        int[] memo = new int[c + 1];
        for (int i = 0; i <= c; i++) {
            memo[i] = (i >= w[0] ? v[0] : 0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = c; j >= w[i]; j--) {
                    memo[j] = Math.max(memo[j], v[i] + memo[j - w[i]]);

            }
        }
        return memo[c];
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] w = {200, 600, 100, 180, 300, 450};
        int[] v = {6, 10, 3, 4, 5, 8};
        int c = 1000;
        System.out.println(knapsack01(w, v, c));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
