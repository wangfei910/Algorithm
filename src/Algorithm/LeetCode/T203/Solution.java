package Algorithm.LeetCode.T203;

import Algorithm.common.ListNode;
import Algorithm.common.ListNodeUtil;


/**
 * 删除链表元素
 * <p>
 * 从具有val值的整数链表中删除所有元素。
 * 例子:
 * 输入:1->2->6->3->4->5->6,val = 6
 * 输出:1 - > 2 - > 3 - > 4 - > 5
 *
 * @author: wangfei
 * @date: 2019/5/23 23:24
 */
public class Solution {

    /**
     * 虚拟头结点
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        //虚拟头结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                //要删除的结点
                ListNode delNode = cur.next;
                cur.next = delNode.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }


    public static ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode node = head;
        while (node != null) {
            if (node.val == val) {
                if (prev == null) {
                    head = node.next;
                } else {
                    prev.next = node.next;
                }
            } else {
                prev = node;
            }
            node = node.next;
        }
        return head;
    }

    /**
     * 递归
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements2(ListNode head, int val) {
        if (head == null)
            return null;
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }


    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        int[] arr1 = {1, 2, 6, 3, 4, 5, 6};
        int val = 6;
        listNodeUtil.showListNode(removeElements(listNodeUtil.buildListNode(arr1), val));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
