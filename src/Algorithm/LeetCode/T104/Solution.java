package Algorithm.LeetCode.T104;

import Algorithm.common.TreeNode;

/**
 * 二叉树的最大深度
 * <p>
 * 给定一个二叉树，求它的最大深度。
 * 最大深度是从根节点到最远叶节点的最长路径上的节点数。
 * 注意:叶子是没有子节点的节点。
 * 例子:
 * 给定二叉树[3,9,20,null,null,15,7]，
 *
 * @author: wangfei
 * @date: 2019/5/27 19:54
 */
public class Solution {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
