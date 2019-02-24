class Solution1 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode reverseHead  = null;   //����һ���µĽڵ�������Ž��
        while(cur != null){                       //��������������ʼ����ÿһ���ڵ�
            ListNode Next = cur.next;     //�ȴ���ͷ�ڵ�cur��������Ҫһ��ָ�����洢cur�ĺ�̽ڵ�
            cur.next = reverseHead;        //��cur�ŵ�������ͷ�ڵ��ͷ��
            reverseHead  = cur;               //�ƶ��������ͷָ�룬����ʼ��ָ��������ͷ��
            cur = Next;                             //��������ԭ����Ľڵ㣬��֮ǰָ���ŵĺ�̽ڵ㣬ѭ������
        }
        return reverseHead;
    }
}


class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head; //������С������������������͵��ڵ�����
        ListNode second = head.next;                                  //�����������õ���һ���ڵ���룬������һ�����õ��������second��
        ListNode reverseHead = reverseList(second);        //�����ú�Ľ���洢���������������ս����֮�����õݹ飬���øղŴ�õ�����
        second.next = head;                                                 //����һ���ĵ����Ѿ������secondΪ�׵�����ķ�ת����������second����˷�ת��ɺ��β�ڵ�
��������������������������������                                  //�����β�ڵ��nextָ��һ��ʼ�����ǰ������head�������������ת
        head.next = null;                                                       //�ʼ��ͷ�ڵ�Ҫ���β�ڵ㣬���ں��油nullʹ�����ս�
        return reverseHead; 
    }
}