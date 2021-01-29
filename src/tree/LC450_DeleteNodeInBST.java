package tree;

/**
 * 这道题核心在于，删除的节点我们需要拿某个节点去替换
 * 这个替换的节点，必须是删除节点的右子树的最小节点
 * https://www.youtube.com/watch?v=gcULXE7ViZw
 *
 * 通过这期视频总结：
 * 其实一共有几种情况
 * 1. 这个节点没有儿子 ：直接删除
 * 2. 这个节点有一个儿子 ：删除后将其儿子接到父节点上
 * 3. 这个节点有俩儿子：
 *      a。 找到其右子树的最小节点
 *      b。 把这个值覆盖到当前要删除的节点
 *      c。 删除右子树中那个重复的节点
 */
public class LC450_DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        /**
         * 从这里开始是相当于找到要删除的那个value
         * 这里其实是把函数的返回值接在root的左右接口上
         */
        if (key < root.val) {
            // 待删除节点在左子树中
            root.left = deleteNode(root.left, key);
            return root;
        } else if (key > root.val) {
            // 待删除节点在右子树中
            root.right = deleteNode(root.right, key);
            return root;
        }
        /**
         * else的话，说明已经找到了那个要删除的值
         * 注意第24行，我们要找那个接口
         */
        else {
            // key == root.val，root 为待删除节点
            if (root.left == null) {
                // 返回右子树作为新的根
                return root.right;
            } else if (root.right == null) {
                // 返回左子树作为新的根
                return root.left;
            } else {
                // 左右子树都存在，返回后继节点（右子树最左叶子）作为新的根
                // 这里，后继节点的的右子树的最左节点，其实就是右边的最小节点

                // 找到这个节点
                TreeNode successor = min(root.right);

                // 右节点使用这个函数，这个函数的意思！！其实就是最开始的2
                successor.right = deleteMin(root.right);

                // 左节点不变，所以直接把【要更换节点的左子树】加到新节点的左边
                successor.left = root.left;
                return successor;
            }
        }
    }

    private TreeNode min(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    private TreeNode deleteMin(TreeNode node) {

        // 如果当前节点的左边啥也没有了！那说明这个节点就是最小节点
        // 所以我们相当于直接把他删掉，把他的右儿子放到他当前位置就好了
        if (node.left == null) {
            //这里return node.right是接在80行的，父亲节点的左接口上
            //父亲节点的左子树，如果再没有左子树了，那么就把这个节点删掉，把他的右子树接过来。
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }
}

