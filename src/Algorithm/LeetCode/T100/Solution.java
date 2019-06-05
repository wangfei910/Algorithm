package Algorithm.LeetCode.T100;

import Algorithm.common.TreeNode;

/**
 * 一样的树
 * <p>
 * 给定两棵二叉树，编写一个函数来检查它们是否相同。
 * 如果两个二叉树在结构上是相同的，并且节点具有相同的值，则认为它们是相同的。
 *
 * @author: wangfei
 * @date: 2019/5/27 20:24
 */
public class Solution {

    /**
     * 递归
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q)
            return true;
        if ((p == null && q != null) || (p != null && q == null) || p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
