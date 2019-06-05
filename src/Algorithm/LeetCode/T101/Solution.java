package Algorithm.LeetCode.T101;

import Algorithm.common.TreeNode;

/**
 * 对称的树
 * <p>
 * 给定一个二叉树，检查它是否是自身的镜像(即围绕其中心对称)。
 * 例如，这个二叉树[1,2,2,3,4,4,3]是对称的:
 *
 * @author: wangfei
 * @date: 2019/5/27 20:41
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        return isSame(root, root);
    }

    /**
     * 100题解
     * 左右子树递归
     *
     * @param left
     * @param right
     * @return
     */
    private boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;
        return isSame(left.left, right.right) && isSame(left.right, right.left);
    }
}
