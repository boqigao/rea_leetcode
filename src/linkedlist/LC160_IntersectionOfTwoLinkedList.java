package linkedlist;

/**
 * @see Sword52_SameNodeOfTwoLinkedList
 */
public class LC160_IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode dummyA = headA;
        ListNode dummyB = headB;

        while (headA != headB) {
            if (headA == null) {
                headA = dummyB;
            } else {
                headA = headA.next;
            }

            if (headB == null) {
                headB = dummyA;
            } else {
                headB = headB.next;
            }
        }

        return headA;
    }
}
