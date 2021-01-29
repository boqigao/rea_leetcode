package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 非递归版解题思路：
 *
 * 二叉树的非递归遍历是每次将当前结点右孩子节点和左孩子节点依次压入栈中，注意是先右后左。
 * 然后将出栈节点输出，并且在将其右子节点和左子节点压入栈中。
 * 推广到N叉树，就是将当前结点的孩子节点由右到左依次压入栈中。
 * 然后将出栈节点输出，并且将其孩子节点依次压入栈中。
 * 时间复杂度O（N），空间复杂度O（N）
 */
public class LC589_NTreePreorderTraversalNoRecursion {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        if(root == null){
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);

            for(int i = node.children.size()-1;
                    i >= 0;
                    i--) {
                stack.push(node.children.get(i));
            }
        }
        return res;
    }
}
