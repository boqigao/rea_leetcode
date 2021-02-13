package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class M04_03ListOfDepthLcci {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[0];
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);

        List<ListNode> list = new ArrayList<>();
        ListNode dummyHead = new ListNode(-1);
        while (!queue.isEmpty()) {
            // 注意这里需要给每一列虚拟一个dummyHead
            ListNode cur = dummyHead;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                tree = queue.poll();
                cur.next = new ListNode(tree.val);
                cur = cur.next;

                if(tree.left != null) {
                    queue.offer(tree.left);
                }

                if(tree.right != null) {
                    queue.offer(tree.right);
                }
            }
            list.add(dummyHead.next);
        }

        ListNode[] res = new ListNode[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;

    }
}
