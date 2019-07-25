package Algorithm.Test.T7;

import java.util.Scanner;

/**
 * @author: wangfei
 * @date: 2019/5/15 19:43
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] xy = new int[n][2];
        for (int i = 0; i < n; i++) {
            xy[i][0] = sc.nextInt();
            xy[i][1] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[][] ab = new int[m][4];
        for (int i = 0; i < m; i++) {
            ab[i][0] = sc.nextInt();
            ab[i][1] = sc.nextInt();
            ab[i][2] = sc.nextInt();
            ab[i][3] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (xy[j][0] >= ab[i][0] && xy[j][0] <= ab[i][2] && xy[j][1] >= ab[i][1] && xy[j][1] <= ab[i][3]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
