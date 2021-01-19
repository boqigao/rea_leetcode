package tree;

import java.util.*;

// 这道题需要用队列
// 先准备一个大的res空list，然后让根节点进队列
// 然后根节点出队列，将根节点的数组放进res
// 然后跟节点的下一层的子节点都进队列，进完了以后出队列
// 重复此工作
public class LC107_Binary_tree_level_order_traversal_II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null) return Collections.emptyList();

        List<List<Integer>> res = new ArrayList<>();
        // q 是装载每一行节点的队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        //当队列为空的时候，说明所有数据已经跑完一遍，看30,31行
        while(!q.isEmpty()){
            // l是每一行的存结果的数组
            List<Integer> l = new ArrayList<>();
            TreeNode x = new TreeNode();
            // 这里size的意思是，每一行有多少个节点
            int s = q.size();
            while(s!=0) {
                // x出队列,并且其儿子入队列
                x = q.poll();
                // 将x的值放入这行的结果数组
                l.add(x.val);
                if (x.left!=null)q.offer(x.left);
                if (x.right!=null)q.offer(x.right);

                // s--保证了只会出上一行节点数量的node
                s--;
            }
            if(!l.isEmpty()) res.add(l);
        }
        Collections.reverse(res);
        return res;
    }
}
