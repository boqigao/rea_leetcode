package tree;

import java.util.ArrayList;
import java.util.List;

public class LC589_NTreePreorderTraversalRecursion {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        res.add(root.val);

        for(Node son : root.children) {
            preorder(son);
        }

        return res;
    }
}


