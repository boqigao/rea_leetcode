package linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC83_RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        if (head == null) {
            return null;
        }
        ListNode dummy = head;
        set.add(head.val);
        while (head!=null && head.next!=null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy;
    }
}
