package Algorithm.LeetCode.T191;

/**
 * Number of 1 Bits(汉明权重)
 *
 * @author: wangfei
 * @date: 2019/4/2 16:41
 */
public class Solution {

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static int hammingWeight2(int n) {
        if (n == 0)
            return 0;
        int count = 1;
        while ((n &= n - 1) != 0)
            count++;
        return count;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int n = 00000000000000000000000000001011;
        System.out.println(hammingWeight2(n));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
