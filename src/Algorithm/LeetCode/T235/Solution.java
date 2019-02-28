package Algorithm.LeetCode.T235;

import Algorithm.LeetCode.common.TreeNode;

/**
 * 二叉搜索树的最低公共祖先
 *
 * @author wangfei
 */
public class Solution {
    public static TreeNode lowestCommonAncestorSearch(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestorSearch(root.left, p, q);
        TreeNode right = lowestCommonAncestorSearch(root.right, p, q);
        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }

    //TODO
    public static void main(String[] args) {

    }
}
