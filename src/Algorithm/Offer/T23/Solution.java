package Algorithm.Offer.T23;

/**
 * 二叉搜索树的后序遍历序列
 *
 * @author: wangfei
 * @date: 2019/4/4 21:53
 */
public class Solution {

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0)
            return false;
        return isBST(sequence, 0, sequence.length - 1);
    }

    /**
     * BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），
     * 如果去掉最后一个元素的序列为T，那么T满足：T可以分成两段，前一段（左子树）小于x，
     * 后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。
     *
     * @param sequence
     * @param start
     * @param end
     * @return
     */
    private boolean isBST(int[] sequence, int start, int end) {
        //递归终止条件
        if (start >= end)
            return true;
        int i = start;
        //左子树节点小于根节点
        for (; i < end; i++) {
            if (sequence[i] > sequence[end])
                break;
        }
        //右子树节点大于根节点
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end])
                return false;
        }
        return isBST(sequence, start, i - 1) && isBST(sequence, i, end - 1);
    }
}
