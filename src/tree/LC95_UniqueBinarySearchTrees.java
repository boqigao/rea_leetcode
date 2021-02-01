package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 对于连续整数序列[left, right]中的一点i，若要生成以i为根节点的BST，则有如下规律：
 *
 * i左边的序列可以作为左子树结点，且左儿子可能有多个，所以有vector<TreeNode *> left_nodes = generate(left, i - 1);；
 * i右边的序列可以作为右子树结点，同上所以有vector<TreeNode *> right_nodes = generate(i + 1, right);；
 * 产生的以当前i为根结点的BST（子）树有left_nodes.size() * right_nodes.size()个，遍历每种情况，即可生成以i为根节点的BST序列；
 * 然后以for循环使得[left, right]中每个结点都能生成子树序列。
 */
// 这道题非常难，有空需要再深入理解
public class LC95_UniqueBinarySearchTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return helper(1, n);
    }

    private List<TreeNode> helper(int lo, int hi) {
        List<TreeNode> result = new ArrayList<>();
        // base case
        if(lo > hi) {
            result.add(null);
            // 这里实际上是最底层了，return了一颗空树
            return result;
        }

        // 这道题只有在这里才使用了递归，其实就是for遍了当前所有可能
        for (int i = lo; i <= hi; i++){
            // 这里直观意义上很好理解，通过递归算出左右子树，然后再接到根上即可
            // 注意，这里是得到的其实并不是左右子树，而是一个左右子树node的list
            // 但是实际上这里生成的就是，[ 左 当前 右]
            // 的所有左右根节点 （注意树的根节点是带着其子树的！！），这样就可以理解了
            List<TreeNode> left = helper(lo, i-1);
            List<TreeNode> right = helper(i+1, hi);

            // 对于每一个左子树和右子树节点
            for(TreeNode l : left){
                for(TreeNode r: right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }
        return result;

    }
}
