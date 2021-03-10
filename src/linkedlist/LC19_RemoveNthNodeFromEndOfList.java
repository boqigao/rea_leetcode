package linkedlist;

public class LC19_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            if (fast.next == null){
                // 这里很重要！哈哈
                return head.next;
            }
            fast = fast.next;
        }

        while (fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
