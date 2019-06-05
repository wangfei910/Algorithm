package Algorithm.LeetCode.T338;

import java.util.Arrays;

/**
 * Counting Bits
 *
 * @author: wangfei
 * @date: 2019/4/2 17:04
 */
public class Solution {

    /**
     * 递归式：f[i] = f[i / 2] + i % 2。
     *
     * @param num
     * @return
     */
    public static int[] countBits(int num) {
        int[] arr = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            arr[i] = arr[i >> 1] + (i & 1);
        }
        return arr;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int num = 2;
        System.out.println(Arrays.toString(countBits(num)));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
