package linkedlist;

public class Sword22_GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode dummy = head;

        int cnt = 1;
        while (dummy.next != null) {
            dummy = dummy.next;
            cnt++;
        }
        dummy = head;
        for (int i = 0; i < cnt-k; i++) {
            dummy = dummy.next;
        }

        return dummy;
    }
}
