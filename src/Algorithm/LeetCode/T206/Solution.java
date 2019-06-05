package Algorithm.LeetCode.T206;

import Algorithm.common.ListNode;
import Algorithm.common.ListNodeUtil;

import java.util.ArrayList;

/**
 * 反转单链表
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
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode second = head.next;
        ListNode reverseHead = reverseList2(second);
        second.next = head;
        head.next = null;
        return reverseHead;
    }

    /**
     * 主程序
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        int[] arr = {1, 2, 3, 4, 5};
        listNodeUtil.showListNode(listNodeUtil.buildListNode(arr));
        listNodeUtil.showListNode(reverseList(listNodeUtil.buildListNode(arr)));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
