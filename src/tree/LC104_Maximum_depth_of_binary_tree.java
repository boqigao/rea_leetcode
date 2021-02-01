package tree;

/**
 * 高度相关的同样问题，见110
 */
public class LC104_Maximum_depth_of_binary_tree {
    public int maxDepth(TreeNode root) {
        return maxNodes(root, 0);
    }

    public int maxNodes(TreeNode node, int sum) {
        // 增加判定
        // 这里的意思是只有实体的子节点才会走到15行的+1，否则直接返回当前的层数
        if(node == null) {
            return sum;
        }
        // 这里+1是因为往下层跑的话，sum已经增加了一层深度
        return Math.max(maxNodes(node.left, sum + 1),
                maxNodes(node.right, sum + 1));
    }
}
