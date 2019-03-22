package Algorithm.Offer.T10;

/**
 * 矩阵覆盖
 *
 * @author wangfei
 */
public class Solution {
    /**
     * 1.第一块放 2 * 1 的位置，则剩下有 f(n - 1) 种覆盖方式
     * 2.第一块放 1 * 2 的位置，则对应的 2 * 2 的矩形中另一块的位置也被确定，剩下 f(n - 2) 种覆盖方式
     * 3.f(n) = f(n - 1) + f(n - 2), n > 2
     *
     * @param target
     * @return
     */
    public static int RectCover(int target) {
        if (target <= 2)
            return target;
        int result1 = 1;
        int ressult2 = 2;
        int ressult = 0;
        for (int i = 3; i <= target; i++) {
            ressult = result1 + ressult2;
            result1 = ressult2;
            ressult2 = ressult;
        }
        return ressult;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int target = 3;
        System.out.println(RectCover(target));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
