package Algorithm.LeetCode.T19;

import Algorithm.common.ListNode;
import Algorithm.common.ListNodeUtil;

/**
 * 删除链表倒数第N个结点
 * <p>
 * 给定一个链表，从链表末尾删除第n个节点并返回其头部。
 * 例子:
 * 给出链表:1->2->3->4->5,n = 2。
 * 从末尾删除第二个节点后，链表变为1->2->3->5。
 *
 * @author: wangfei
 * @date: 2019/5/24 21:19
 */
public class Solution {

    /**
     * 双指针
     * 1、定义p、q两个间距 n + 1 的指针
     * 2、同时向后移动两个指针，直到后一个指针指向空结点， p.next 则为要删除的节点
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p = dummy;
        ListNode q = dummy;
        for (int i = 0; i < n + 1; i++) {
            q = q.next;
        }
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        ListNode delNode = p.next;
        p.next = delNode.next;
        return dummy.next;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        int[] arr1 = {1, 2, 3, 4, 5};
        int n = 2;
        listNodeUtil.showListNode(removeNthFromEnd(listNodeUtil.buildListNode(arr1), n));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
