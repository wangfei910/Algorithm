package Algorithm.LeetCode.T83;

import Algorithm.common.ListNode;
import Algorithm.common.ListNodeUtil;

/**
 * 从已排序链表中删除重复项
 * <p>
 * 给定一个已排序的链表，删除所有重复项，使每个元素只出现一次。
 * 示例1:
 * 输入:1 - > 1 - > 2
 * 输出:1 - > 2
 *
 * @author: wangfei
 * @date: 2019/5/23 22:06
 */
public class Solution {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            if (cur.val == next.val) {
                cur.next = next.next;
            } else {
                cur = next;
            }
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
        int[] arr = {1, 1, 2, 3, 3};
        listNodeUtil.showListNode(listNodeUtil.buildListNode(arr));
        listNodeUtil.showListNode(deleteDuplicates(listNodeUtil.buildListNode(arr)));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
