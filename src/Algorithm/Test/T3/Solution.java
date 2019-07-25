package Algorithm.Test.T3;

import java.util.Scanner;

/**
 * 走斜线
 *
 * @author: wangfei
 * @date: 2019/4/5 17:25
 */
public class Solution {

    /**
     * 要到达目的地花费的最小步数是x和y的最大值，如果k小于这个值就一定到不了。如果k溢出了，
     * 那么在整个k步里，最多只会走两条直线。分别是如下三种情况（令x<=y）：0条直线（y-x）
     * 是偶数且（k-x）是偶数；1条直线（y-x）是奇数；2条直线（y-x）是偶数且（k-x）是奇数。
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int T = in.nextInt();
            for (; T > 0; T--) {
                int x = in.nextInt();
                int y = in.nextInt();
                int k = in.nextInt();
                int temp;
                if (x > y) {
                    temp = x;
                    x = y;
                    y = temp;
                }
                if (y > k) {
                    System.out.println("-1");
                }
                int ans = k;
                if ((y - x) % 2 != 0)
                    ans--;
                else if ((k - x) % 2 != 0)
                    ans -= 2;
                System.out.println(ans);
            }
        }
    }

}
