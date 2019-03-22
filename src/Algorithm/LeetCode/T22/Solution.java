package Algorithm.LeetCode.T22;

import java.util.ArrayList;
import java.util.List;


/**
 * 生成有效括号
 *
 * @author wangfei
 */
public class Solution {
    /**
     * 递归（深度优先搜索）
     * 时间复杂度为O(2^n)
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generateOneByOne("", result, n, n);
        return result;
    }

    /**
     * 递归+剪枝（辅助函数）
     *
     * @param subList
     * @param result
     * @param left
     * @param right
     */
    public static void generateOneByOne(String subList, List<String> result, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(subList);
            return;
        }
        if (left > 0) {
            generateOneByOne(subList + "(", result, left - 1, right);
        }
        if (right > left) {
            generateOneByOne(subList + ")", result, left, right - 1);
        }
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int n = 4;
        System.out.println(generateParenthesis(n));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
