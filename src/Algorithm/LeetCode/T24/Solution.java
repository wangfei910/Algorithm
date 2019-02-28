package Algorithm.LeetCode.T24;

import Algorithm.LeetCode.common.ListNode;
import Algorithm.LeetCode.common.ListNodeUtil;

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

    public static ListNode swapPairs2(ListNode head) {
        if (head == null)
            return null;
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode pre = helper;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next.next;
            cur.next.next = cur;
            pre.next = cur.next;
            if (next != null && next.next != null)
                cur.next = next.next;
            else
                cur.next = next;
            pre = cur;
            cur = next;
        }
        return helper.next;
    }

    public static void main(String[] args) {
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        int[] arr = {1, 2, 3, 4, 5};
        listNodeUtil.showListNode(listNodeUtil.buildListNode(arr));
        System.out.println();
        listNodeUtil.showListNode(swapPairs(listNodeUtil.buildListNode(arr)));
    }
}