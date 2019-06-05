package Algorithm.LeetCode.T237;

import Algorithm.common.ListNode;

/**
 * 删除链表中的节点
 * <p>
 * 编写一个函数来删除单链表中的一个节点(尾巴除外)，该函数只允许访问该节点。
 *
 * @author: wangfei
 * @date: 2019/5/24 21:12
 */
public class Solution {

    public static void deleteNode(ListNode node) {
        if (node == null)
            return;
        if (node.next == null)
            node = null;

        node.val = node.next.val;
        ListNode delNode = node.next;
        node.next = delNode.next;
    }
}
