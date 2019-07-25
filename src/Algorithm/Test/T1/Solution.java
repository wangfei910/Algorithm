package Algorithm.Test.T1;

import java.util.Scanner;

/**
 * 开锁
 *
 * @author: wangfei
 * @date: 2019/4/5 17:25
 */
public class Solution {

    /**
     * 对每个数字，比较是加过去步数少，还是减过去步数少即可。
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            String str1 = in.next();
            String str2 = in.next();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int temp = Math.abs(str1.charAt(i) - str2.charAt(i));
                if (temp <= 5) {
                    sum += temp;
                } else {
                    sum += (10 - temp);
                }
            }
            System.out.println(sum);
        }
    }
}
