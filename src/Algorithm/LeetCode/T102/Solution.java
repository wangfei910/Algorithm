package Algorithm.LeetCode.T102;

import Algorithm.LeetCode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 按层遍历二叉树
 *
 * @author
 */
public class Solution {
    public ArrayList<Integer> levelOrder(TreeNode root) {
        ArrayList<Integer> resList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return resList;
        else {
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode tempNode = queue.remove();
                resList.add(tempNode.val);
                if (tempNode.left != null)
                    queue.offer(tempNode.left);
                if (tempNode.right != null)
                    queue.offer(tempNode.right);
            }
            return resList;
        }
    }

    //TODO
    public static void main(String[] args) {

    }
}
