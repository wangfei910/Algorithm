package Algorithm.LeetCode.T226;

import Algorithm.common.TreeNode;

/**
 * @author: wangfei
 * @date: 2019/5/27 20:04
 */
public class Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
