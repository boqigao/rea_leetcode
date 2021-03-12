package linkedlist;

import java.util.Stack;

public class LC233_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode dummy = head;
        int len = 1;
        while (head.next!= null) {
            head = head.next;
            len++;
        }
        head = dummy;
        int mid = len / 2;

        Stack<Integer> stack = new Stack<>();

        if (len % 2 == 0) {
            for (int i = 0; i < mid; i++) {
                stack.push(head.val);
                head = head.next;
            }
            while (head!=null) {
                if (head.val != stack.pop()) {
                    return false;
                }
                head = head.next;
            }
        } else {
            for (int i = 0; i < mid; i++) {
                stack.push(head.val);
                head = head.next;
            }
            head = head.next;
            while (head!=null) {
                if (head.val != stack.pop()) {
                    return false;
                }
                head = head.next;
            }
        }

        return true;
    }
}
