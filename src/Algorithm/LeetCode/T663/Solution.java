package Algorithm.LeetCode.T663;

/**
 * 平方和
 *
 * @author: wangfei
 * @date: 2019/4/8 19:50
 */
public class Solution {

    /**
     * 题目描述：判断一个数是否为两个数的平方和。
     *
     * @param c
     * @return
     */
    public static boolean judgeSquareSum(int c) {
        int a = 0, b = (int) Math.sqrt(c);
        while (a <= b) {
            int powSum = a * a + b * b;
            if (powSum == c) {
                return true;
            } else if (powSum > c) {
                b--;
            } else {
                a++;
            }
        }
        return false;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int c = 4;
        System.out.println(judgeSquareSum(c));
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start) + "ms");
    }
}
