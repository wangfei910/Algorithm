package Algorithm.LeetCode.T111;

import Algorithm.common.TreeNode;

/**
 * 二叉树的最小深度
 * <p>
 * 给定一个二叉树，求它的最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数。
 * 注意:叶子是没有子节点的节点。
 * 例子:
 * 给定二叉树[3,9,20,null,null,15,7]，
 *
 * @author: wangfei
 * @date: 2019/5/27 20:01
 */
public class Solution {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null)
            return minDepth(root.right) + 1;
        if (root.right == null)
            return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
