package Algorithm.Offer.T62;

import Algorithm.common.TreeNode;

import java.util.Stack;

/**
 * 二叉树搜索第k个结点
 * <p>
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 *
 * @author: wangfei
 * @date: 2019/5/14 20:03
 */
public class Solution {

    /**
     * 二叉树的中序遍历是有序数组，中序遍历后找到第 K 个数
     * 1、节点不为空，沿着左子树一直压栈，直到节点为空
     * 2、节点为空，则出栈（出栈值为从小到大），沿着出栈节点的右子树走一步
     * 3、栈为空，节点为空，则结束循环
     *
     * @param pRoot
     * @param k
     */
    public TreeNode KthNode1(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = pRoot;
        do {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (--k == 0) {
                    return node;
                }
                node = node.right;
            }
        }
        while (node != null || !stack.isEmpty());
        return null;
    }

}
