package Algorithm.LeetCode.T112;

import Algorithm.common.TreeNode;

/**
 * 路径之和
 * <p>
 * 给定一棵二叉树和一个和，确定该树是否有根到叶的路径，以便将路径上的所有值相加等于给定的和。
 * 注意:叶子是没有子节点的节点。
 * 例子:
 * 给出下面的二叉树，sum = 22，
 *
 * @author: wangfei
 * @date: 2019/5/27 21:02
 */
public class Solution {

    /**
     * 递归
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return root.val == sum;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
