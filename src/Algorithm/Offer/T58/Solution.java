package Algorithm.Offer.T58;

import Algorithm.common.TreeNode;

/**
 * 对称的二叉树
 * <p>
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * @author: wangfei
 * @date: 2019/5/14 15:34
 */
public class Solution {

    /**
     * 1、pRoot 的左子树 left 和右子树 right
     * 2、left 的右子树 == right 的左子树 && left 的左子树 == right 的右子树，不断递归
     * 3、递归终止条件：左右子树均为空，返回 true；其他均返回 false
     *
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null || (pRoot.left == null && pRoot.right == null))
            return true;
        return doIsSymmetrical(pRoot.left, pRoot.right);
    }

    private boolean doIsSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left != null && right != null && left.val == right.val) {
            return doIsSymmetrical(left.left, right.right) && doIsSymmetrical(left.right, right.left);
        }
        return false;
    }
}
