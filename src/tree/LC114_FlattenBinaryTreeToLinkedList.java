package tree;

import java.util.Stack;

/**
 * 这道题应该自己敲还比较困难，主要记住是要用栈就好了
 */
public class LC114_FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            //先压右边，再压左边的话，这样取得时候就是先取左边
            if(cur.right!=null) stack.push(cur.right);
            if(cur.left!=null) stack.push(cur.left);

            if(!stack.isEmpty()) {
                // 如果有左边存在的话
                // 看一眼左边，同时把左边接到根节点右边，这样可以起到铺平的效果
                // 但是不能取他，因为到时候还要把根的右边再接到这个儿子的右边

                // 如果左边不存在的话，peek出来的东西就是本身的右边，所以毫无影响
                cur.right = stack.peek();
            }
            cur.left = null;
        }
    }
}
