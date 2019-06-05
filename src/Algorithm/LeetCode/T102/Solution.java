package Algorithm.LeetCode.T102;

import Algorithm.common.TreeNode;
import javafx.util.Pair;

import java.util.*;

/**
 * 按层遍历二叉树
 *
 * @author wangfei
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        helper(result, 0, root);
        return result;
    }

    /**
     * 广度优先搜索
     *
     * @param result
     * @param index
     * @param root
     */
    private void helper(List<List<Integer>> result, int index, TreeNode root) {
        if (root == null) {
            return;
        }
        List<Integer> level;
        if (result.size() == index) {
            level = new ArrayList<>();
            result.add(level);
        } else {
            level = result.get(index);
        }
        level.add(root.val);
        helper(result, index + 1, root.left);
        helper(result, index + 1, root.right);
    }


    //TODO
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start) + "ms");
    }
}
