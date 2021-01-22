package tree;

import java.util.*;

public class LC103_BinaryTreeZigZagOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        //在这里添加一个level！通过level奇偶来判定
        int level = 0;

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

            if (level % 2 == 1){
                Collections.reverse(l);
            }
            if(!l.isEmpty()) {
                res.add(l);
            }
            level++;

        }
        return res;
    }
}
