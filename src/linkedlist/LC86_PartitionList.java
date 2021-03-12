package linkedlist;

/**
 * 小于x的存到l1 大于x的存到l2
 * 然后l1.next = l2接起来
 * 再把l2的头返回去
 */
public class LC86_PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);
        ListNode node1 = dummyHead1;
        ListNode node2 = dummyHead2;
        while (head != null) {
            if (head.val < x) {
                node1.next = head;
                head = head.next;
                node1 = node1.next;
                node1.next = null;
            } else {
                node2.next = head;
                head = head.next;
                node2 = node2.next;
                node2.next = null;
            }
        }
        node1.next = dummyHead2.next;
        return dummyHead1.next;
    }
}
