package Algorithm.LeetCode.T437;

import Algorithm.common.TreeNode;

/**
 * 路径之和
 * <p>
 * 给定一个二叉树，其中每个节点包含一个整数值。
 * 找出与给定值求和的路径数。
 * 路径不需要从根节点或叶子节点开始或结束，但是它必须向下(只从父节点移动到子节点)。
 * 树的节点不超过1,000个，值的范围在-1,000,000到1,000,000之间。
 * 例子:
 * 根= [10,5，-3,3,2,null,11,3，-2,null,1]， sum = 8
 *
 * @author: wangfei
 * @date: 2019/5/28 21:04
 */
public class Solution {

    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int res = findPath(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }

    private int findPath(TreeNode node, int sum) {
        if (node == null)
            return 0;
        int res = 0;
        if (node.val == sum)
            res += 1;
        res += findPath(node.left, sum - node.val);
        res += findPath(node.right, sum - node.val);
        return res;
    }
}
