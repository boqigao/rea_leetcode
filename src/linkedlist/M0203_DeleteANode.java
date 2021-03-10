package linkedlist;

/**
 * 这题太蠢
 */
public class M0203_DeleteANode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
