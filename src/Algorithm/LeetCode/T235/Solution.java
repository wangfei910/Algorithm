package Algorithm.LeetCode.T235;

import Algorithm.common.TreeNode;

/**
 * 二叉搜索树的最低公共祖先
 * <p>
 * 给定二叉搜索树(BST)，找到BST中两个给定节点的最低公共祖先(LCA)。
 * 根据Wikipedia对LCA的定义:“在两个节点p和q之间定义的最低公共祖先是T中同时具有p和q作为后代的最低节点(在这里，
 * 我们允许一个节点作为其自身的后代)。”
 * 给定二叉搜索树:根= [6,2,8,0,4,7,9,null,null,3,5]
 *
 * @author wangfei
 */
public class Solution {

    public TreeNode lowestCommonAncestorSearch(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestorSearch(root.right, p, q);
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestorSearch(root.left, p, q);
        return root;
    }
}
