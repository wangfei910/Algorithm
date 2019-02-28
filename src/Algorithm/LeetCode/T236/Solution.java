package Algorithm.LeetCode.T236;

import Algorithm.LeetCode.common.TreeNode;

/**
 * 二叉树的最低公共祖先
 *
 * @author wangfei
 */
public class Solution {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        if ((root.val > p.val) && root.val > q.val)
            return lowestCommonAncestor2(root.left, p, q);
        if ((root.val < p.val) && root.val < q.val)
            return lowestCommonAncestor2(root.right, p, q);
        return root;
    }

    //TODO
    public static void main(String[] args) {

    }
}
