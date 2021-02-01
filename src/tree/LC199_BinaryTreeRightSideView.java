package tree;

import java.util.*;

/**
 * 这道题有两种解法：1。层序遍历找到每层最后一个节点即可
 *
 * 2。
 * dfs：访问顺序，self，right，left
 * 我们要加一个 node的值和level相关结果
 * 按照此访问顺序，每次碰到第一个新level的数字，就是我们要打印的结果
 * 我们要保证每次碰到新的level就能将它加入，所以level==res.size()
 */
public class LC199_BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        dfs(root, res, 0);
        return res;
    }

    public void dfs(TreeNode root, List<Integer> res, int level) {
        if (root == null) {
            return;
        }

        //当我们看到一个新的level的时候，我们就将其加入结果、
        // 这个做法比较核心
        if(level == res.size()) {
            res.add(root.val);
        }

        // 先做右边，再做左边，保证右边会被先记录进res
        dfs(root.right, res, level+1);
        dfs(root.left, res, level+1);
    }

    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {

                TreeNode curNode = q.poll();
                // 检测一下是不是这一行的最后一个node！
                if (i == size-1){
                    res.add(curNode.val);
                }
                if (curNode.left!=null) q.offer(curNode.left);
                if (curNode.right!=null) q.offer(curNode.right);
            }
        }
        return res;
    }
}
