package Algorithm.Offer.T18;

import Algorithm.common.TreeNode;

/**
 * 二叉树镜像
 *
 * @author wangfei
 */
public class Solution {

    /**
     * 递归
     *
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root != null) {
            Swap(root);
            Mirror(root.left);
            Mirror(root.right);
        } else
            return;
    }

    /**
     * 交换位置
     *
     * @param root
     */
    public void Swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
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
