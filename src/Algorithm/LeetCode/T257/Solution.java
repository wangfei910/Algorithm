package Algorithm.LeetCode.T257;

import Algorithm.common.TreeNode;

import java.util.*;

/**
 * 二叉树路径
 * <p>
 * 给定一个二叉树，返回所有根到叶的路径。
 * 注意:叶子是没有子节点的节点。
 *
 * @author: wangfei
 * @date: 2019/5/27 21:12
 */
public class Solution {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root == null)
            return res;
        if (root.left == null && root.right == null) {
            res.add(Integer.toString(root.val));
            return res;
        }
        for (String left : binaryTreePaths(root.left)) {
            res.add(Integer.toString(root.val) + "->" + left);
        }
        for (String right : binaryTreePaths(root.right)) {
            res.add(Integer.toString(root.val) + "->" + right);
        }
        return res;
    }

    /**
     * BFS - Queue
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> list = new ArrayList<>();
        Queue<TreeNode> qNode = new LinkedList<>();
        Queue<String> qStr = new LinkedList<>();

        if (root == null) return list;
        qNode.add(root);
        qStr.add("");
        while (!qNode.isEmpty()) {
            TreeNode curNode = qNode.remove();
            String curStr = qStr.remove();

            if (curNode.left == null && curNode.right == null)
                list.add(curStr + curNode.val);
            if (curNode.left != null) {
                qNode.add(curNode.left);
                qStr.add(curStr + curNode.val + "->");
            }
            if (curNode.right != null) {
                qNode.add(curNode.right);
                qStr.add(curStr + curNode.val + "->");
            }
        }
        return list;
    }

    /**
     * DFS - Stack
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths3(TreeNode root) {
        List<String> list = new ArrayList<>();
        Stack<TreeNode> sNode = new Stack<>();
        Stack<String> sStr = new Stack<>();

        if (root == null) return list;
        sNode.push(root);
        sStr.push("");
        while (!sNode.isEmpty()) {
            TreeNode curNode = sNode.pop();
            String curStr = sStr.pop();

            if (curNode.left == null && curNode.right == null)
                list.add(curStr + curNode.val);
            if (curNode.left != null) {
                sNode.push(curNode.left);
                sStr.push(curStr + curNode.val + "->");
            }
            if (curNode.right != null) {
                sNode.push(curNode.right);
                sStr.push(curStr + curNode.val + "->");
            }
        }
        return list;
    }
}
