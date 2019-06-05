package Algorithm.LeetCode.T52;

/**
 * N 皇后问题
 *
 * @author: wangfei
 * @date: 2019/4/18 18:30
 */
public class Solution {

    public static int count = 0;
    private static int size;

    /**
     * 位运算
     *
     * @param n
     * @return
     */
    public static int totalNQueens(int n) {
        size = (1 << n) - 1;
        solve(0, 0, 0);
        return count;
    }

    private static void solve(int row, int ld, int rd) {
        if (row == size) {
            count++;
            return;
        }
        int pos = size & (~(row | ld | rd));
        while (pos != 0) {
            int p = pos * (-pos);
            pos -= p;
            solve(row + p, (ld + p) << 1, (rd + p) >> 1);
        }
    }

    public static int totalNQueens2(int n) {
        return bt(new boolean[n], new boolean[2 * n], new boolean[2 * n], 0, n);
    }

    private static int bt(boolean[] c, boolean[] f, boolean[] b, int row, int n) {
        if (row == n)
            return 1;
        int ans = 0;
        for (int col = 0; col < n; ++col) {
            int i = col + row, j = col - row + n;
            if (c[col] || f[i] || b[j])
                continue;
            c[col] = f[i] = b[j] = true;
            ans += bt(c, f, b, row + 1, n);
            c[col] = f[i] = b[j] = false;
        }
        return ans;
    }

    public int totalNQueens3(int n) {
        int ans = 0;
        int[] queens = new int[n];
        boolean[] c = new boolean[n + 1];
        boolean[] f = new boolean[2 * n];
        boolean[] b = new boolean[2 * n];
        c[n] = true; //dummy boundary
        int col = 0, row = 0;
        while (true) {
            if (c[col] || f[col + row] || b[col - row + n]) {
                if (row == n || col == n) {
                    if (row == 0) return ans;
                    if (row == n) ans++;
                    col = queens[--row];
                    c[col] = f[col + row] = b[col - row + n] = false;
                }
                col++;
            } else {
                c[col] = f[col + row] = b[col - row + n] = true;
                queens[row++] = col;
                col = 0;
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
        int n = 1;
        System.out.println(totalNQueens(n));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
