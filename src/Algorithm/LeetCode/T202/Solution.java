package Algorithm.LeetCode.T202;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐的数字
 * <p>
 * 编写一个算法来确定一个数字是否“幸福”。
 * 快乐的数量是一个数字定义为以下过程:从任何正整数,取代数的平方和的位数,并重复这个过程,直到数= 1(它将保持),
 * 或者它无休止地循环周期,不包括1。这个过程以1结束的那些数字是幸福的数字。
 *
 * @author: wangfei
 * @date: 2019/5/21 13:07
 */
public class Solution {

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            int res = 0;
            while (n != 0) {
                res += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (set.contains(res)) {
                return false;
            } else {
                set.add(res);
                n = res;
            }
        }
        return true;
    }

    public static boolean isHappy2(int n) {
        if (n <= 0)
            return false;
        while (true) {
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }
            if (sum / 10 == 0) {
                if (sum == 1 || sum == 7)
                    return true;
                else
                    return false;
            }
            n = sum;
        }
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int n = 19;
        System.out.println(isHappy(n));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
