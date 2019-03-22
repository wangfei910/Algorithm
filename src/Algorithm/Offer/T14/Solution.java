package Algorithm.Offer.T14;

import Algorithm.common.ListNode;
import Algorithm.common.ListNodeUtil;

/**
 * 链表中倒数第K个结点
 *
 * @author wangfei
 */
public class Solution {
    /**
     * 1.指针 first 指向 head，指针 last 指向正数第 K 个节点
     * 2.first 和 last 同时向前运动，当 last 走到最后一个节点时，first 指向的节点就是倒数第 K 个节点
     * 时间复杂度为O(N)
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0)
            return null;
        ListNode first = head;
        ListNode last = head;
        int count = 1;
        while (last.next != null) {
            last = last.next;
            ++count;
            if (count > k)
                first = first.next;
        }
        if (count < k)
            return null;
        else
            return first;
    }

    public static ListNode FindKthToTail2(ListNode head, int k) {
        ListNode p, q;
        p = q = head;
        int i = 0;
        for (; p != null; i++) {
            if (i >= k)
                q = q.next;
            p = p.next;
        }
        return i < k ? null : q;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        ListNode head = listNodeUtil.buildListNode(arr);
        int k = 7;
        System.out.println(FindKthToTail(head, k).val);
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
