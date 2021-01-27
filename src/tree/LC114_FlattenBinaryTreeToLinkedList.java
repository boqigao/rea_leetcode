package tree;

import java.util.Stack;

public class LC114_FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            //先压右边，再压左边的话，这样取得时候就是先取左边
            if(cur.right!=null) stack.push(cur.right);
            if(cur.left!=null) stack.push(cur.right);

            if(!stack.isEmpty()) {
                // 看一眼左边，先不取，这样才能返回去
                cur.right = stack.peek();
            }
            cur.left = null;
        }
    }
}
