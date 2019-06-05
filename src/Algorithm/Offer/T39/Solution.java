package Algorithm.Offer.T39;

import Algorithm.common.TreeNode;

/**
 * 平衡二叉树
 * <p>
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * @author: wangfei
 * @date: 2019/5/8 21:52
 */
public class Solution {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null)
            return true;
        return TreeDepth(root) != -1;
    }

    /**
     * 从下往上遍历，如果子树是平衡二叉树，则返回子树的高度；
     * 如果发现子树不是平衡二叉树，则直接停止遍历，这样至多只对每个结点访问一次(用 -1 标记)。
     *
     * @param root
     * @return
     */
    private int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = TreeDepth(root.left);
        if (left == -1)
            return -1;
        int right = TreeDepth(root.right);
        if (right == -1)
            return -1;
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }
}
