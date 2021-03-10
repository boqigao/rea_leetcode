package linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 那其实前面那道题也能用pq来做
 */
public class LC23_MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode list :  lists) {
            if (list == null) {
                continue;
            }
            pq.add(list);
        }

        while (!pq.isEmpty()) {
            ListNode next = pq.poll();
            cur.next = next;
            cur = cur.next;
            if (next.next != null) {
                pq.add (next.next);
            }
        }
        return dummyHead.next;
    }
}
