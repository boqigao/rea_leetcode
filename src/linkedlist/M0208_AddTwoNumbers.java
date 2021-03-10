package linkedlist;

public class M0208_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ans = new ListNode(0);
        ListNode cur = ans;

        while (l1 != null || l2 != null){
            int num1, num2;
            if (l1 == null) {
                num1 = 0;
            } else {
                num1 = l1.val;
            }

            if (l2 == null) {
                num2 = 0;
            } else {
                num2 = l2.val;
            }

            int num = num1 + num2 + carry;

            carry = num / 10;

            cur.next = new ListNode(num % 10);

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null){
                l2 = l2.next;
            }

            cur = cur.next;
        }

        if (carry == 1){
            cur.next = new ListNode(1);
        }

        return ans.next;
    }
}
