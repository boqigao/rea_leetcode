package linkedlist;

public class LC82_RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = new ListNode();
        p.next = head;
        head = p;

        ListNode left, right;

        while (p.next != null) {
            left = p.next;
            right = left;
            while (right.next != null && right.next.val == left.val) {
                right = right.next;
            }
            if (left == right) {
                p = p.next;
            } else{
                p.next = right.next;
            }
        }
        return head.next;
    }
}
