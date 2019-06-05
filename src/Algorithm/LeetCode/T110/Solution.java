package Algorithm.LeetCode.T110;

import Algorithm.common.TreeNode;

/**
 * 完全二叉树
 * <p>
 * 给定一个二叉树，判断它是否高度平衡。
 * 对于该问题，定义高度平衡二叉树为:
 * 一种二叉树，其中每个节点的两个子树的深度相差不超过1。
 * 示例1:
 * 给定如下树[3,9,20,null,null,15,7]
 *
 * @author: wangfei
 * @date: 2019/5/28 19:48
 */
public class Solution {

    private boolean res = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return res;
    }

    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left - right) > 1)
            res = false;
        return Math.max(left, right) + 1;
    }


    public boolean isBalanced2(TreeNode root) {
        if (root == null)
            return true;
        return check(root) != -1;
    }

    private int check(TreeNode root) {
        if (root == null)
            return 0;
        int left = check(root.left);
        if (left == -1)
            return left;
        int right = check(root.right);
        if (right == -1)
            return right;
        int diff = Math.abs(left - right);
        if (diff > 1)
            return -1;
        return Math.max(left, right) + 1;
    }
}