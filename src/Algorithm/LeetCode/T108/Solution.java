package Algorithm.LeetCode.T108;

import Algorithm.common.TreeNode;

/**
 * 将有序数组转换为二叉搜索树
 * <p>
 * 给定一个按升序排列元素的数组，将其转换为高度平衡的BST。
 * 对于该问题，高度平衡二叉树定义为每个节点的两个子树深度相差不超过1的二叉树。
 *
 * @author: wangfei
 * @date: 2019/5/28 21:44
 */
public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null)
            return null;
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right)
            return null;
        if (left == right)
            return new TreeNode(nums[left]);
        int mid = left + (right - left) / 2;
        //中间是根节点
        TreeNode root = new TreeNode(nums[mid]);
        //前半部分是左子树
        root.left = helper(nums, left, mid - 1);
        //后半部分是右子树
        root.right = helper(nums, mid + 1, right);
        return root;
    }

}
