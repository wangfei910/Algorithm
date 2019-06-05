package Algorithm.Offer.T56;

import Algorithm.common.ListNode;
import Algorithm.common.ListNodeUtil;

/**
 * 删除链表中重复的结点
 * <p>
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * @author: wangfei
 * @date: 2019/5/12 22:02
 */
public class Solution {

    /**
     * 递归
     * 1、0 || 1 个节点，直接返回
     * 2、当前节点重复节点，while 删除，然后从第一个与当前节点不同的节点开始递归
     * 3、当前节点不是重复节点，保留节点递归
     *
     * @param pHead
     * @return
     */
    public static ListNode deleteDuplication(ListNode pHead) {
        // 只有0个或1个结点，则返回
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        // 当前结点是重复结点
        if (pHead.val == pHead.next.val) {
            ListNode pNode = pHead.next;
            while (pNode != null && pNode.val == pHead.val) {
                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                pNode = pNode.next;
            }
            // 从第一个与当前结点不同的结点开始递归
            return deleteDuplication(pNode);
        } else {
            // 保留当前结点，从下一个结点开始递归
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

    /**
     * 快慢指针
     * 1、新建一个 newHead.next = pHead
     * 2、快指针 fast = pHead，慢指针 slow = newHead
     * 3、首先判断 fast != null && fast.next != null，满足条件进入循环
     * 4、如果当前节点不重复，fast 和 slow 依次向前平移
     * 5、如果当前节点重复，即 fast.val = fast.next.val，记录 value = fast.val，与 value 相等的节点，全部删除，再移动 slow
     *
     * @param pHead
     * @return
     */
    public static ListNode deleteDuplication2(ListNode pHead) {
        ListNode preHead = new ListNode(-1);
        preHead.next = pHead;
        ListNode slow = preHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null) {
            if (fast.val == fast.next.val) {
                int value = fast.val;
                while (fast != null && fast.val == value) {
                    fast = fast.next;
                }
                slow.next = fast;
            } else {
                slow = fast;
                fast = fast.next;
            }
        }
        return preHead.next;
    }


    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        int[] arr = new int[]{2, 2, 3, 3, 4, 4, 5, 6};
        ListNode pHead = listNodeUtil.buildListNode(arr);
        listNodeUtil.showListNode(deleteDuplication(pHead));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }

}
