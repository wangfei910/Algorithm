package Algorithm.LeetCode.T24;

import Algorithm.common.ListNode;
import Algorithm.common.ListNodeUtil;

/**
 * 交换链表相邻两个元素
 *
 * @author wangfei
 */
public class Solution {

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if ((head == null) || (head.next == null))
            return head;
        ListNode Next = head.next;
        head.next = swapPairs(head.next.next);
        Next.next = head;
        return Next;
    }

    /**
     * 双指针
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            node2.next = node1;
            node1.next = next;
            p.next = node2;

            p = node1;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        int[] arr = {1, 2, 3, 4, 5};
        listNodeUtil.showListNode(listNodeUtil.buildListNode(arr));
        System.out.println();
        listNodeUtil.showListNode(swapPairs2(listNodeUtil.buildListNode(arr)));
    }
}