package Algorithm.LeetCode.T11;

/**
 * 含水最多的容器
 * <p>
 * 给定n个非负整数a1 a2…，其中每个点表示坐标(i, ai)处的一个点。画出n条垂直线，使得直线i的两个端点
 * 在(i, ai)和(i, 0)处。找出两条直线，这两条直线和x轴构成一个容器，使得容器中含有最多的水。
 *
 * @author: wangfei
 * @date: 2019/5/19 17:14
 */
public class Solution {

    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                max = Math.max((r - l) * height[l], max);
                l++;
            } else {
                max = Math.max((r - l) * height[r], max);
                r--;
            }
        }
        return max;
    }


    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
