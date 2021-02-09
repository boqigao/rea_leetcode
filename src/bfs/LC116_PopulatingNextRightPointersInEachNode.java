package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LC116_PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {

        if(root == null)return null;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node curNode = q.poll();

                if(i == size-1){
                    curNode.next = null;
                } else {
                    curNode.next = q.peek();
                }

                if(curNode.left!=null) q.offer(curNode.left);
                if(curNode.right!=null) q.offer(curNode.right);

            }
        }

        return root;
    }
}

class LC116_RecurSolution {
    public Node connect(Node root) {
        if(root == null || root.left == null)
            return root;
        root.left.next = root.right;
        if(root.next != null){
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
