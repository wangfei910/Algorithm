package Algorithm.Offer.T16;

import Algorithm.common.ListNode;
import Algorithm.common.ListNodeUtil;

/**
 * 合并两个排序的链表
 *
 * @author wangfei
 */
public class Solution {

    /**
     * 递归
     * 1. 两值相比，讨论大小两种情况
     * 2. 若 list1.val 小，则当前插入的节点为 list1，后续节点为 list1.next = Merge()
     * 3. 若 list2.val 小，则当前插入的节点为 list2，后续节点为 list2.next = Merge()
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val <= list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list2.next, list1);
            return list2;
        }
    }

    /**
     * 非递归
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge2(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(-1);
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode cur = res;
        while (list1 != null && list2 != null) {
            int val1 = list1.val;
            int val2 = list2.val;
            if (val1 <= val2) {
                cur.next = new ListNode(val1);
                list1 = list1.next;
            } else {
                cur.next = new ListNode(val2);
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null)
            cur.next = list1;
        if (list2 != null)
            cur.next = list2;
        return res.next;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        int[] list1 = new int[]{1, 3, 4, 5, 7, 9};
        int[] list2 = new int[]{2, 4, 6, 7, 8, 10};
        listNodeUtil.buildListNode(list1);
        listNodeUtil.buildListNode(list2);
        listNodeUtil.showListNode(Merge2(listNodeUtil.buildListNode(list1), listNodeUtil.buildListNode(list2)));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
