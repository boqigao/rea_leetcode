package linkedlist;

/**
 * 核心是要知道快指针走的路是满指针2倍
 * 假设链表是
 *
 *      a       b x
 *  1 2 3 4 5 6 7 8
 *      |         |
 *      <<<<<<<<<<
 * 那么他们相遇的地点是在 b， 绕回来的地方假设是a
 * 那么慢节点走了 a + b
 *
 * 快节点走了 2（a + b）
 * 同时假设相遇点到链表末尾的距离是 x
 * 那又可以计算得到快节点走的距离是 a + b + x + b
 * 这里可以得到 a = x
 * 因此弄一个新节点从头开始，和慢节点一起从相遇地点走，他们会走a部相遇
 */
public class LC142_LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        /**
         * 哇终于想清楚原因了！！！
         * 这个写法slow和fast相遇的地点不对
         */
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        assert slow==fast;
        ListNode res = head;
        while (res != slow) {
            res = res.next;
            slow = slow.next;
        }

        return res;
    }
}
