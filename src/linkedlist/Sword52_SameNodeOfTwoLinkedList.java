package linkedlist;

/**
 * 太6了，我的理解：
 * 两个链表长度分别为L1+C、L2+C， C为公共部分的长度，按
 * 照楼主的做法： 第一个人走了L1+C步后，回到第二个人起点走L2步；
 * 第2个人走了L2+C步后，回到第一个人起点走L1步。
 * 当两个人走的步数都为L1+L2+C时就两个家伙就相爱了
 *
 * @see LC141_LinkedListCycle
 * 思路很像
 */
public class Sword52_SameNodeOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode h1 = headA, h2 = headB;
        while (h1 != h2) {

            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }

        return h1;
    }
}
