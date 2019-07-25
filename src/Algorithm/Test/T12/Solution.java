package Algorithm.Test.T12;

import Algorithm.common.ListNode;
import Algorithm.common.ListNodeUtil;

/**
 * 有序链表插入元素
 *
 * @author: wangfei
 * @date: 2019/7/14 19:10
 */
public class Solution {

    public static ListNode insertNode(ListNode head, ListNode node) {
        ListNode duy = new ListNode(0);
        duy.next = head;
        while (duy.next != null && duy.next.val < node.val) {
            duy = duy.next;
        }
        ListNode Next = duy.next;
        duy.next = node;
        node.next = Next;
        return head;
    }

    /**
     * 主程序
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        int[] arr = {1, 2, 3, 5, 6};
        int[] arr1 = {4};
        listNodeUtil.showListNode(listNodeUtil.buildListNode(arr));
        listNodeUtil.showListNode(listNodeUtil.buildListNode(arr1));
        listNodeUtil.showListNode(insertNode(listNodeUtil.buildListNode(arr), listNodeUtil.buildListNode(arr1)));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
