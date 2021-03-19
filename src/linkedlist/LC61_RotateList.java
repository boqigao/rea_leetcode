package linkedlist;

public class LC61_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode dummy = head;
        int j = 1;
        while (dummy!=null) {
            dummy = dummy.next;
            j++;
        }
        dummy.next = head;
        j = k % j;
        for (int i = 0; i < j; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            dummy = dummy.next;
        }
        ListNode res = slow;

        for (int i = 0; i < j-1; i++) {
            slow = slow.next;
        }

        dummy.next = null;
        slow.next = head;


        return res;
    }
}
