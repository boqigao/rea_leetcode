package linkedlist;

public class Lc148_MergeSortOfLinkedList {
    public ListNode sortList(ListNode head) {
        return head == null ? null : mergeSort(head);
    }

    private ListNode mergeSort (ListNode head) {
        if(head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head;

        while (fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l1 = head;
        ListNode l2 = slow.next;
        slow.next = null;
        l1 = mergeSort(l1);
        l2 = mergeSort(l2);

        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode head = res;
        while (l1!=null || l2!=null) {
            if (l1 == null) {
                res.next = l2;
                l2 = l2.next;
                res = res.next;
            }else
            if (l2 == null) {
                res.next = l1;
                res = res.next;
                l1 = l1.next;
            }else {
                if (l1.val <= l2.val) {
                    res.next = l1;
                    l1 =l1.next;
                } else {
                    res.next = l2;
                    l2 = l2.next;
                }
                res =res.next;
            }
        }

        return head.next;
    }
}
