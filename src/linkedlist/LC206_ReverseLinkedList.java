package linkedlist;

public class LC206_ReverseLinkedList {
    //迭代法
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //尾递归
    public ListNode reverseList1(ListNode head) {
        return reverse(null,head);
    }

    private static ListNode reverse(ListNode pre,ListNode cur){
        if(cur==null) return pre;
        ListNode next = cur.next;
        cur.next = pre;
        return reverse(cur,next);
    }
}
