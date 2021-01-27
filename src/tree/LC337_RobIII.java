package tree;

import java.util.*;

/**
 * 然而情况并非如此，直到我遇到了 [2,1,3,null,4]
 * 这样的测试用例（有多少人是死在这步的，挥动手中的荧光棒让我看到你们）：
 * 题意并非如隔层求解和那么简单。原因在于对于相邻的两层节点，
 * 第一层右边的节点和第二层左边的节点完全可以求和的（此时我的内心是奔溃的😭）
 *
 * 此时5和6是可以求和的，
 *     4
 *   1   5
 * 6
 *
 * 经过仔细分析（手动严肃脸），正确的解题思路大致是这样的：
 *
 * 对于一个以 node 为根节点的二叉树而言，如果尝试偷取 node 节点，那么势必不能偷取其左右子节点，然后继续尝试偷取其左右子节点的左右子节点。
 *
 * 如果不偷取该节点，那么只能尝试偷取其左右子节点。
 *
 * 比较两种方式的结果，谁大取谁。
 */
public class LC337_RobIII {

    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> memo = new HashMap<>();
        return tryRob(root, memo);
    }

    private int tryRob (TreeNode node, HashMap<TreeNode, Integer> memo){
        if(node== null) {
            return 0;
        }
        if(memo.containsKey(node)) return memo.get(node);

        //尝试偷取该节点
        // 尝试偷取该节点的话，就一定不可能偷该节点的直接的儿子，应该是尝试偷该节点的
        // 左儿子的左右和右儿子的左右
        int res1 = 0;
        if(node.left!=null){
            res1 += (tryRob(node.left.left, memo) + tryRob(node.left.right, memo));
        }

        if(node.right!=null){
            res1 += (tryRob(node.right.left, memo) + tryRob(node.right.right, memo));
        }

        res1 += node.val;

        // 不偷取该节点
        int res2 = tryRob(node.left,memo) + tryRob(node.right, memo);


        int result = Math.max(res1, res2);
        memo.put(node, result);
        return result;

    }

    public int wrongAnswer(TreeNode root) {
        if (root == null){
            return 0;
        }
        int oddMax = 0;
        int evenMax = 0;


        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        TreeNode curNode = null;
        while (!q.isEmpty()){

            int size = q.size();
            for(int i = 0; i < size; i++) {
                curNode = q.poll();
                if(level%2 == 0){
                    oddMax += curNode.val;
                } else {
                    evenMax += curNode.val;
                }
                if(curNode.left!=null)q.offer(curNode.left);
                if(curNode.right!=null) q.offer(curNode.right);
            }

            level++;
        }

        return Math.max(oddMax, evenMax);
    }
}
