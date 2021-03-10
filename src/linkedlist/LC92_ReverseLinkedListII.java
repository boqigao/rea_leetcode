package linkedlist;

public class LC92_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int cnt = 1;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        while (cnt < left) {
            pre = pre.next;
        }
        head = pre.next;

        // 12345
        // 13245
        //每次操作核心是把head的next接到pre后面，这样就能把最后面的数字放到最前！
        for (int i = left; i < right; i++) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummy.next;
    }
}
