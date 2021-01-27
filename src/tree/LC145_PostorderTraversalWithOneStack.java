package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 这道题核心是往左走往左走，然后出栈入栈
 */
public class LC145_PostorderTraversalWithOneStack {
    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode current = root;
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> s = new Stack<>();

        while (!s.isEmpty() || current != null) {
            if (current != null) {
                // 首先一路往左走，碰到就压栈，全压进去
                s.push(current);
                current = current.left;
            } else {
                // 直到碰到null了，我们就返回到上一个节点，看一眼他有没有右儿子
                // 这时候这个节点确保没有左儿子了
                // 因为后序遍历是左，右，中
                TreeNode tmp = s.peek().right;
                // 如果他没有右儿子，那么可以理解为我们已经访问了这个节点的
                // null左儿子以及null右儿子，因此可以直接访问这个节点了
                if (tmp == null) {
                    tmp = s.pop();
                    res.add(tmp.val);
                    // 此时，我们需要看一眼当前的tmp是不是栈顶节点的右儿子
                    // 如果是的话，说明我们已经访问完了栈顶节点的右子树
                    // 这个时候需要将栈顶节点出栈
                    while (!s.isEmpty() && tmp == s.peek().right){
                        tmp = s.pop();
                        res.add(tmp.val);
                    }
                } else {
                    // 如果他的右儿子非null，那么我们需要访问其右子树
                    // 记住这个时候tmp = s.peek().right了
                    current = tmp;
                }
            }
        }

        return res;
    }
}
