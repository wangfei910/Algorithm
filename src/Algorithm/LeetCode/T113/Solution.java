package Algorithm.LeetCode.T113;

import Algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 路径之和
 * <p>
 * 给定一个二叉树和一个和，找出所有根到叶的路径，其中每个路径的和等于给定的和。
 * 注意:叶子是没有子节点的节点。
 * 例子:
 * 给出下面的二叉树，sum = 22，
 *
 * @author: wangfei
 * @date: 2019/5/27 21:29
 */
public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        PathSum(root, sum, new ArrayList<>(), res);
        return res;
    }

    private void PathSum(TreeNode root, int sum, ArrayList<Integer> list, List<List<Integer>> res) {
        if (root == null)
            return;
        list.add(root.val);
        if (root.left == null &&root.right == null && sum == root.val) {
            res.add(new ArrayList<>(list));
        } else {
            PathSum(root.left, sum - root.val, list, res);
            PathSum(root.right, sum - root.val, list, res);
        }
        list.remove(list.size() - 1);
    }
}
