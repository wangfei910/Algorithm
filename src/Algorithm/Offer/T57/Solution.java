package Algorithm.Offer.T57;

import Algorithm.common.TreeNode;

/**
 * 二叉树的下一个结点
 * <p>
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * @author: wangfei
 * @date: 2019/5/12 23:00
 */
public class Solution {

    /**
     * 1、中序遍历中下一个节点出现的情况
     * 2、当前节点为叶节点
     * （1）如果为 root 节点，直接返回 null
     * （2）如果当前节点在左叶子节点，出现在父节点
     * （3）如果当前节点在右叶子节点，向上遍历父节点，直到父节点为左节点
     * 3、当前节点围殴 root 节点
     * （1）右节点存在，沿着右节点的左节点一直寻找，直到叶子节点
     * （2）右节点不存在，向上遍历父节点，直到父节点为左节点
     * 4、总结
     * （1）右子树不为空时，沿着右子树的左节点一直寻找，直到找到叶子节点
     * （2）右子树为空时，向上遍历父节点，直到父节点为左节点，输出父节点
     *
     * @param pNode
     * @return
     */
    public TreeNode GetNext(TreeNode pNode) {
        if (pNode == null)
            return null;
        //如果有右子树，则找右子树的最左节点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        //没右子树，则找第一个当前节点是父节点的左孩子的节点
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        //退到了根节点仍没找到，则返回null
        return null;
    }
}
