package Algorithm.Test.T10;

import Algorithm.common.ListNode;
import Algorithm.common.ListNodeUtil;

/**
 * @author: wangfei
 * @date: 2019/6/4 20:31
 */
public class Solution {

    /**
     * 翻转链表的从结点m到结点n的部分
     *
     * @param head 连标点额头结点
     * @param m    翻转的开始位置
     * @param n    翻转的结束位置
     * @return 翻转后的新链表
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int k = n - m;
        int j = m;
        while (j > 1) {
            dummy = dummy.next;
            j--;
        }
        ListNode Next = dummy.next;
        while (k > 0) {
            ListNode temp = Next.next;
            Next.next = Next.next.next;
            temp.next = dummy.next;
            dummy.next = temp;
            k--;
        }
        if (m == 1) {
            head = dummy.next;
        }
        return head;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int m = 4, n = 5;
        listNodeUtil.showListNode(listNodeUtil.buildListNode(arr));
        listNodeUtil.showListNode(reverseBetween(listNodeUtil.buildListNode(arr), m, n));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
