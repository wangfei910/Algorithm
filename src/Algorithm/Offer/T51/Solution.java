package Algorithm.Offer.T51;

import java.util.Arrays;

/**
 * 构建乘积数组
 * <p>
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 *
 * @author: wangfei
 * @date: 2019/5/11 21:19
 */
public class Solution {

    /**
     * 1、不包含 A[i]
     * 2、从左向右累乘，从右向左累乘
     *
     * @param A
     * @return
     */
    public static int[] multiply(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        for (int i = 0, product = 1; i < len; product *= A[i], i++)
            B[i] = product;
        for (int i = len - 1, product = 1; i >= 0; product *= A[i], i--)
            B[i] *= product;
        return B;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(multiply(A)));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
