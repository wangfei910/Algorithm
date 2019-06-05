package Algorithm.LeetCode.T236;

import Algorithm.common.TreeNode;

/**
 * 二叉树的最低公共祖先
 *
 * @author wangfei
 */
public class Solution {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }

}
