package Algorithm.Offer.T59;

import Algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 按之字形顺序打印二叉树
 * <p>
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二行按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * @author: wangfei
 * @date: 2019/5/14 15:45
 */
public class Solution {

    /**
     * 1、利用 Queue 进行层序遍历
     * 2、奇数行List 直接添加到 resList
     * 3、偶数行 List 反转后再添加到 resList
     * 4、Tips:
     * （1）list == null 理解为没有为 list 分配空间
     * （2）list.size() == 0 理解为为 list 分配了空间，但是 list 中没有元素
     *
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (pRoot == null)
            return resList;
        queue.offer(pRoot);
        int count = 1;
        int size = 0;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.remove();
                if (node == null) {
                    continue;
                }
                list.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if (count % 2 == 0) {
                Collections.reverse(list);
            }
            if (list.size() != 0) {
                resList.add(list);
            }
            count++;
        }
        return resList;
    }
}
