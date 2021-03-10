package linkedlist;

public class LC21_MergeSortedLists {
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
