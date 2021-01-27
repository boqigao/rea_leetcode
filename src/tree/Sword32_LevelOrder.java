package tree;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sword32_LevelOrder {
    public int[] levelOrder(TreeNode root) {
        if(root == null) {
            return new int[0];
        }
        List<Integer> l = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);


        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++){
                TreeNode tmpNode = q.poll();
                l.add(tmpNode.val);

                if(tmpNode.left!=null) {
                    q.offer(tmpNode.left);
                }

                if(tmpNode.right!=null) {
                    q.offer(tmpNode.right);
                }
            }
        }

        int[] res = new int[l.size()];

        for(int i = 0; i < l.size(); i++){
            res[i] = l.get(i);
        }
        return res;

    }
}
