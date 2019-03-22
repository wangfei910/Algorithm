package Algorithm.Offer.T11;

/**
 * 二进制中1的个数
 *
 * @author wangfei
 */
public class Solution {
    /**
     * 位运算
     * 1.1的二进制为0000 0001 共计32位，每次左移一位为0010，0100，1000
     * 2.移位后与n做&操作，用来检测n的二进制每位上是否为1
     *
     * @param n
     * @return
     */
    public static int NumberOf(int n) {
        int target = 1;
        int count = 0;
        while (target != 0) {
            if ((target & n) != 0) {
                count++;
            }
            target = target << 1;
        }
        return count;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int n = 63;
        System.out.println(NumberOf(n));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
