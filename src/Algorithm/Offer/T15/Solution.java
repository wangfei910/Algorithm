package Algorithm.Offer.T15;

import Algorithm.common.ListNode;
import Algorithm.common.ListNodeUtil;

/**
 * 反转链表
 *
 * @author wangfei
 */
public class Solution {
    /**
     * 创建一个新节点来存放结果，遍历链表，处理每一个节点
     * 1.将当前指针放到新链表的头节点
     * 2.移动新链表的头指针，让他始终指向新链表的头部
     * 3.继续处理原链表节点，循环往复
     *
     * @param head
     * @return
     */
    public static ListNode ReverseList(ListNode head) {
        ListNode cur = head;
        ListNode resHead = null;
        while (cur != null && cur.next != null) {
            ListNode Next = cur.next;
            cur.next = resHead;
            resHead = cur;
            cur = Next;
        }
        return resHead;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public static ListNode ReverseList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode Next = head.next;
        ListNode resHead = ReverseList2(Next);
        Next.next = head;
        head.next = null;
        return resHead;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        int[] arr = {1, 2, 3, 4, 5};
        listNodeUtil.showListNode(listNodeUtil.buildListNode(arr));
        listNodeUtil.showListNode(ReverseList2(listNodeUtil.buildListNode(arr)));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
