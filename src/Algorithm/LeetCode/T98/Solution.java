package Algorithm.LeetCode.T98;

import Algorithm.LeetCode.common.TreeNode;

/**
 * 验证二叉搜索树
 *
 * @author wangfei
 */
public class Solution {
    public static boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean helper(TreeNode root, long min, long max) {
        if (root == null)
            return true;
        if (root.val <= min || root.val >= max)
            return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    //TODO
    public static void main(String[] args) {

    }
}
