package Algorithm.LeetCode.T95;

import Algorithm.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 不同的二叉搜索树
 * <p>
 * 给定一个数字 n，要求生成所有值为 1...n 的二叉搜索树。
 *
 * @author: wangfei
 * @date: 2019/5/4 22:14
 */
public class Solution {

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new LinkedList<>();
        return generateSubtrees(1, n);
    }

    private static List<TreeNode> generateSubtrees(int s, int e) {
        List<TreeNode> res = new LinkedList<>();
        if (s > e) {
            res.add(null);
            return res;
        }
        for (int i = s; i <= e; ++i) {
            List<TreeNode> leftSubtrees = generateSubtrees(s, i - 1);
            List<TreeNode> rightSubtrees = generateSubtrees(i + 1, e);
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }

}
