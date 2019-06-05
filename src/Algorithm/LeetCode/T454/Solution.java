package Algorithm.LeetCode.T454;

import java.util.HashMap;
import java.util.Map;

/**
 * 四个数之和 II
 * <p>
 * 给出四个整数值的列表A、B、C、D，计算有多少元组(i、j、k、l)使得A[i] + B[j] + C[k] + D[l]为零。
 * 为了使问题简单一点，所有的a, B, C, D都有相同的长度N，其中0≤N≤500。、
 * 所有整数的范围都在-2^28到2^28 - 1之间，结果保证不超过2^31 - 1。
 *
 * @author: wangfei
 * @date: 2019/5/22 0:20
 */
public class Solution {

    /**
     * 查找表
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n^2)
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (count.containsKey(A[i] + B[j])) {
                    count.put((A[i] + B[j]), count.get(A[i] + B[j]) + 1);
                } else {
                    count.put((A[i] + B[j]), 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                if (count.containsKey(0 - C[i] - D[j])) {
                    res += count.get(0 - C[i] - D[j]);
                }
            }
        }
        return res;
    }

    public static int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int numA : A) {
            for (int numB : B) {
                int sumAB = numA + numB;
                hashMap.put(sumAB, hashMap.getOrDefault(sumAB, 0) + 1);
            }
        }
        for (int numC : C){
            for (int numD : D){
                int sumCD = numC + numD;
                count += hashMap.getOrDefault(-sumCD,0);
            }
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
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        System.out.println(fourSumCount(A, B, C, D));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
