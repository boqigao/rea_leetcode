package dfs;

import java.util.List;

/**
 * 这道题要求的是高度平衡的bst，因此并不是随便一个bst都行
 *
 * 这道题核心是一个找中点，因此设计到一个linkedlist的快慢指针的问题
 */
public class LC109_SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        // 我们假定链表的结尾是一个null
        return helper(head, null);
    }

    public TreeNode helper(ListNode start, ListNode end){
        if (start==end){
            return null;
        }
        ListNode slow = start;
        ListNode fast = start;

        // 使用这种方法找中点，让fast走的速度是slow的两倍, 因为fast肯定比slow快，所以我们只要判定fast就可以了
        // 这样找到的slow就是中点
        while (fast !=end && fast.next!=end) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);

        // 然后就递归寻找就可以了
        root.left = helper(start, slow);
        root.right = helper(slow.next, end);
        return root;
    }
}
