package bfs;

import java.util.*;

public class LC515_FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }


        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            int valueInCurLayer = Integer.MIN_VALUE;
            for(int i = 0; i < size; i ++) {
                TreeNode curNode = q.poll();
                valueInCurLayer = Math.max(valueInCurLayer, curNode.val);


                if(curNode.left!=null) q.offer(curNode.left);
                if(curNode.right!=null) q.offer(curNode.right);
            }
            res.add(valueInCurLayer);
        }

        return res;
    }
}
