package tree;

import java.util.ArrayList;
import java.util.List;

// 这道题有几个点，需要留意
// 1. dfs里面，传入的值一般有一个结果的对象，然后dfs不停的处理这个结果
// 2. 最外侧生成currentpath，这样里面稍微处理一下就可以无限添加，因为他是string形式，
// 所以不存在一个object不能添加的情况

public class LC257_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();

        if (root == null) return res;

        String currentPath = Integer.toString(root.val);
        if (root.left == null && root.right == null) res.add(currentPath);
        if (root.left != null) dfs(root.left, currentPath, res);
        if (root.right != null) dfs(root.right, currentPath, res);


        return res;
    }

    public void dfs (TreeNode node,
                     String currentPath,
                     List<String> res) {
        currentPath += "->" + node.val;

        // 走到叶子节点的时候，即可将其加入结果
        if (node.left == null && node.right == null) {
            res.add(currentPath);
            return;
        }

        if (node.left != null) dfs(node.left, currentPath, res);
        if (node.right != null) dfs(node.right, currentPath, res);
    }
}
