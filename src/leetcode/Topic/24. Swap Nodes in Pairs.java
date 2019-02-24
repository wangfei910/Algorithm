class Solution {
    public ListNode swapPairs(ListNode head){
        if((head == null) || (head.next == null))
            return head;
        ListNode Next = head.next;
        head.next = swapPairs(head.next.next);
        Next.next = head;
        return Next;
    }
}