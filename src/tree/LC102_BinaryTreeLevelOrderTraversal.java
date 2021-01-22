package tree;

import java.util.*;

public class LC102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            TreeNode curNode = new TreeNode();
            int size = q.size();
            for(int i = 0; i < size; i++) {
                curNode = q.poll();
                l.add(curNode.val);
                if(curNode.left!=null)q.offer(curNode.left);
                if(curNode.right!=null) q.offer(curNode.right);
            }

            if(!l.isEmpty()) {
                res.add(l);
            }
        }
        return res;
    }
}
