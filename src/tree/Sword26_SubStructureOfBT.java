package tree;

/**
 * 这道题需要先遍历树a中的每个节点，判断树A中的以各个节点为根节点的子树是否包含树B
 * 这道题主要有一个双层递归比较搞脑子
 */
public class Sword26_SubStructureOfBT {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B ==null) {
            return false;
        }

        // 先判断A是否有B子树
        // 如果当前节点没有，那么就看左儿子右儿子，有没有B子树
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);

    }

    /**
     * 这个函数只负责看A中是否包含B
     * @param A
     * @param B
     * @return
     */
    private boolean dfs(TreeNode A, TreeNode B){

        // 如果b==null，这里代表上层的 B.left 或者B.righe == null
        // 意味着不论A怎么取，至少上层的包含是已经做到了
        if(B==null) return true;
        if(A==null) return false;

        // 这里就一直用dfs比对是否相同就好了，
        return A.val==B.val&&dfs(A.left, B.left) && dfs(A.right,B.right);
    }
}
