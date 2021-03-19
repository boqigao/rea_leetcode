package linkedlist;

import java.util.Stack;

public class LC445_AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()
        || carry > 0) {

            int sum = 0;
            sum += carry;


            if (stack1.isEmpty()) {
                sum += 0;
            } else {
                sum += stack1.pop();
            }

            if (stack2.isEmpty()) {
                sum += 0;
            } else {
                sum += stack2.pop();
            }

            carry = sum / 10;
            sum = sum % 10;

            ListNode node = new ListNode(sum);
            node.next = head;
            head = node;

        }
        return head;
    }
}
