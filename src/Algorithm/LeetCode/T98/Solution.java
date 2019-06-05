package Algorithm.LeetCode.T98;

import Algorithm.common.TreeNode;

/**
 * 验证二叉搜索树
 * <p>
 * 给定一个二叉树，判断它是否是一个有效的二叉搜索树(BST)。
 * 假设BST定义如下:
 * 节点的左子树只包含键值小于节点键值的节点。
 * 节点的右子树只包含键值大于节点键值的节点。
 * 左子树和右子树也必须是二叉搜索树。
 *
 * @author wangfei
 */
public class Solution {

    public static boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean helper(TreeNode root, long minValue, long maxValue) {
        if (root == null)
            return true;
        //root结点的值不是大于最大值（右孩子）且小于最小值（左孩子）的话就返回false
        if (root.val > minValue || root.val < maxValue)
            return false;
        return helper(root.left, minValue, root.val) && helper(root.right, root.val, maxValue);
    }
}
