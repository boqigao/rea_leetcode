package tree;

public class LC437_PathSumIII {
    int res;

    public int pathSum(TreeNode root, int sum) {
        // 所以这道题只能采用双层递归，
        if(root == null) return 0;

        // 首先计算根节点
        backTrack(root,sum);
        // 然后计算左节点
        pathSum(root.left, sum);
        // 然后计算右节点
        pathSum(root.right, sum);

        /**
         * 注意，这个非常重要！！！一定要在主函数递归，不然无法找到所有的节点
         * 在这种正确的情况下，进入左儿子后，也会去继续进入左儿子的左儿子和右儿子
         * 不会有漏网之鱼
         */

        return res;
    }


    public void backTrack(TreeNode root,
                          int sum) {
        if (root==null) return;

        if(root.val==sum){
            res++;
        }

        backTrack(root.left, sum-root.val);
        backTrack(root.right, sum-root.val);

    }


    public int pathSumWrongAnswer(TreeNode root, int sum) {
        res = 0;
        TreeNode save = root;
        if (root == null) return 0;
        backTrack(root, sum);

        /**
         * 极端注意！！！这种写法是错的！！
         * 这种写法，虽然他会backtrack每个根节点，但是这样找寻的根节点是不全的！
         * 这种写法只会找到一棵树最外侧的节点作为根
         *
         *               1
         *             2  3
         *            3 5 6 3
         *
         * 这种情况下他是找不到 5 6作为根的！！
         */
        while (root!=null){
            root = root.right;
            backTrack(root,sum);
        }

        root = save;
        while (root!=null){
            root = root.left;
            backTrack(root,sum);
        }

        return res;
    }
}
