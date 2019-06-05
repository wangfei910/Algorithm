package Algorithm.Offer.T22;

import Algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印二叉树
 *
 * @author: wangfei
 * @date: 2019/4/1 22:27
 */
public class Solution {

    /**
     * 1. 边界检测，空与非空
     * 2. root 节点入队
     * 3. 队列不为空，出队，出队节点的左右子树入队
     *
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return list;
        else {
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.remove();
                list.add(treeNode.val);
                if (treeNode.left != null)
                    queue.offer(treeNode.left);
                if (treeNode.right != null)
                    queue.offer(treeNode.right);
            }
            return list;
        }
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();

        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
