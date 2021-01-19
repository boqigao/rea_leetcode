package tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC94_Binary_tree_inorder_traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if(root==null) return Collections.emptyList();
        Stack<TreeNode> s = new Stack<TreeNode>();
        while(true) {
            if (root!=null){
                s.push(root);
                root = root.left;
            } else {
                if(s.isEmpty()) break;
                root = s.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
