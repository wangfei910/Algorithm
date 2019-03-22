package Algorithm.Offer.T19;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 *
 * @author wangfei
 */
public class Solution {
    /**
     * 1. 上 -> 右 -> 下 -> 左
     * 2. 上下边界判定和左右边界判定
     *
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++)
                res.add(matrix[rowStart][i]);
            for (int i = rowStart + 1; i <= rowEnd; i++)
                res.add(matrix[i][colEnd]);
            if (rowEnd != rowStart)
                for (int i = colEnd - 1; i >= colStart; i--)
                    res.add(matrix[rowEnd][i]);
            if (colEnd != colStart)
                for (int i = rowEnd - 1; i > rowStart; i--)
                    res.add(matrix[i][colStart]);
            ++rowStart;
            --rowEnd;
            ++colStart;
            --colEnd;
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
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(printMatrix(matrix));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
