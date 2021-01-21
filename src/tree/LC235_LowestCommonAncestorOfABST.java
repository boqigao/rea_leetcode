package tree;

// 这道题的核心是，对于bst来说，如果pq都大于root，那肯定pointer要右移，反之同理
// 如果到了某一层以后，pq分别在root两边，那最低的肯定是root，不用再多考虑。
public class LC235_LowestCommonAncestorOfABST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode pointer = root;
        while (pointer != null) {
            if (p.val > pointer.val && q.val > pointer.val){
                pointer = pointer.right;
            } else if (p.val < pointer.val && q.val < pointer.val){
                pointer = pointer.left;
            } else {
                return pointer;
            }
        }
        return null;
    }
}
