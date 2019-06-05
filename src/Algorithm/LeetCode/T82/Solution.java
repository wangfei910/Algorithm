package Algorithm.LeetCode.T82;

import Algorithm.common.ListNode;
import Algorithm.common.ListNodeUtil;

/**
 * 删除链表中的重复元素II
 * <p>
 * 给定一个已排序的链表，删除所有具有重复编号的节点，只留下与原始列表不同的编号。
 * Example 1:
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 *
 * @author: wangfei
 * @date: 2019/5/24 9:25
 */
public class Solution {

    /**
     * 1、循环遍历所有值相同的结点，只保留最后一个
     * 2、删除该结点
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        ListNode node = dummyNode;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head != null && head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                head = head.next;
            } else {
                node.next = new ListNode(head.val);
                head = head.next;
                node = node.next;
            }
        }
        return dummyNode.next;
    }


    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        int[] arr1 = {1, 1, 1, 3, 4, 4, 5};
        listNodeUtil.showListNode(deleteDuplicates(listNodeUtil.buildListNode(arr1)));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
