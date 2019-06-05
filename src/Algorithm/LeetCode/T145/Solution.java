package Algorithm.LeetCode.T145;

import Algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树后序遍历
 *
 * @author: wangfei
 * @date: 2019/5/27 19:33
 */
public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        res.addAll(postorderTraversal(root.left));
        res.addAll(postorderTraversal(root.right));
        res.add(root.val);
        return res;
    }
}
