package Algorithm.Offer.T4;

import Algorithm.common.TreeNode;

import java.util.HashMap;

/**
 * 根据前序和中序遍历重建二叉树
 *
 * @author wangfei
 */
public class Solution {
    private static HashMap<Integer, Integer> map = new HashMap<>();


    /**
     * 1.先序遍历的第一个位置是 root 节点。中序遍历的 root 节点位置在中间 p，在 root 节点左边的肯定是 root 的左子树的中序数组，在 root 节点右边的肯定是 root 的右子树的中序数组。先序遍历的第二个位置到 p，就是 root 左子树的先序数组，p 右边就是 root 右子树的先序数组
     * 2.存储中序遍历的节点和索引值
     * 3.找到先序遍历的 root 节点，初始为左边缘节点，递归过程中不断更新
     * 4.找到 root 节点在中序遍历中的索引，计算出左子树和右子树的大小
     * 5.模拟先序遍历过程，递归插入左子树和右子树
     *
     * @param pre
     * @param mid
     * @return
     */
    public static TreeNode reConstructBinary(int[] pre, int[] mid) {
        for (int i = 0; i < mid.length; i++)
            map.put(mid[i], i);
        return reConstructBinary(pre, 0, pre.length - 1, 0);
    }

    public static TreeNode reConstructBinary(int[] pre, int preL, int preR, int midL) {
        if (preL > preR)
            return null;
        TreeNode root = new TreeNode(pre[preL]);
        int index = map.get(root.val);
        int leftSize = index - midL;
        root.left = reConstructBinary(pre, preL + 1, preL + leftSize, midL);
        root.right = reConstructBinary(pre, preL + leftSize + 1, midL, leftSize + 1);
        return root;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] mid = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        System.out.println(reConstructBinary(pre, mid).val);
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
