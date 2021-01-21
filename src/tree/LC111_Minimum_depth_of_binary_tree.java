package tree;

import java.util.LinkedList;
import java.util.Queue;

// 这道题的核心是bfs
// 需要一个队列！感觉非常像LC107
// 先加儿子，然后把根节点pop出来
public class LC111_Minimum_depth_of_binary_tree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;

        while (!queue.isEmpty()) {
            int numberOfNodes = queue.size();
            depth++;
            for (int i = 0; i < numberOfNodes; i++){
                TreeNode currentNode = queue.remove();
                // 如果左儿子和右儿子都为空，那么我们得到了一个叶子节点
                // 这里理解失误了，只有他同时没有2个儿子的时候，我们才能计算高度
                if (currentNode.left == null
                && currentNode.right ==null) {
                    return depth;
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return depth;
    }
}
