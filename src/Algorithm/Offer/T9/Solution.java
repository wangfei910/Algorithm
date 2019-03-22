package Algorithm.Offer.T9;

/**
 * 变态跳台阶
 *
 * @author wangfei
 */
public class Solution {
    /**
     * f(1) = 1
     * f(2) = 2 = f(1) + 1
     * f(3) = 4 = f(2) + f(1) + 1
     * f(4) = 8 = f(3) + f(2) + f(1) + 1
     * f(n - 1) = f(n - 2) + f(n - 3) + ... + f(1) + 1
     * f(n) = f(n - 1) + f(n - 2) + ... +f(1) + 1
     * 由计算得递推公式：f(n) = 2 * f(n - 1)
     *
     * @param target
     * @return
     */
    public static int JumpFloorII(int target) {
        int[] result = new int[target + 1];
        result[1] = 1;
        for (int i = 2; i <= target; i++) {
            result[i] = 2 * result[i - 1];
        }
        return result[target];
    }

    /**
     * 两层循环
     *
     * @param target
     * @return
     */
    public static int JumpFloorII2(int target) {
        int[] result = new int[target + 1];
        result[1] = 1;
        for (int i = 2; i <= target; i++) {
            for (int j = 1; j < i; j++) {
                result[i] += result[j];
            }
            result[i] += 1;
        }
        return result[target];
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int target = 10;
        System.out.println(JumpFloorII(target));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
