package tree;


/**
 * 这道题有多种做法，最好理解的做法是我们dfs找到这个节点，同时记录
 * 到达节点的所有路径
 * 然后我们对比路径，找到最后一个相同的val，就是需要的结果。
 *
 *
 * 本题解讲的是另外一种算法
 */
public class LC236_LowestCommonAncestorOfABT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
           return null;
        }

        if(root.val == p.val || root.val == q.val){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果左右都不为空，那么说明当前节点是最低的父节点
        if(left!=null && right!=null) {
            return root;
        }

        if(left==null && right == null) {
            return null;
        }

        // 如果左右有一个是空，那么说明 可能
        // 1.，左，右儿子子树里面有一个并不包含p或者q
        // 因此我们直接返回这个树就行
        // 2. 左右子树某一个返回的值已经包含了当前最低的父节点！！！
        // 见第26行
        // 所以不论 1,2哪种情况，我们只要返回这个非空节点即可，非常巧妙的算法
        return left!=null?left:right;
    }
}
