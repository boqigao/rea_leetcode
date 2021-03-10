package linkedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * 1.双端队列 但是属于取巧做法
 * 2.正常做法
 *  1）找到链表中间的位置
 *  2）将后面的链表翻转
 *  3）将两条链表拼接
 */
public class LC143_ReorderList {
    public void reorderList(ListNode head) {
        LinkedList<ListNode> queue = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            queue.addLast(cur);
            cur = cur.next;
        }

        while (!queue.isEmpty()) {
            if (cur == null) {
                cur = queue.pollFirst();
            } else {
                cur.next = queue.pollFirst();
                cur = cur.next;
            }
            cur.next = queue.pollLast();
            cur = cur.next;
        }
        if (cur != null) {
            cur.next = null;
        }
    }
}
