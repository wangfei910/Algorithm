package Algorithm.Offer.T38;

import Algorithm.common.TreeNode;

/**
 * 二叉树的深度
 * <p>
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * @author: wangfei
 * @date: 2019/5/8 21:46
 */
public class Solution {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }else {
            return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
        }
//        return root == null ? 0 : Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }
}
