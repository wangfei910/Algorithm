package Algorithm.Offer.T8;

/**
 * 跳台阶
 *
 * @author wangfei
 */
public class Solution {
    /**
     * 1.f(n) = n, n <= 2
     * 2.f(n) = f(n - 1) + f(n - 2), n >= 3
     *
     * @param target
     * @return
     */
    public static int JumpFloor(int target) {
        if (target <= 2)
            return target;
        int res1 = 1;
        int res2 = 2;
        int res = 0;
        for (int i = 3; i <= target; i++) {
            res = res1 + res2;
            res1 = res2;
            res2 = res;
        }
        return res;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int target = 10;
        System.out.println(JumpFloor(target));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
