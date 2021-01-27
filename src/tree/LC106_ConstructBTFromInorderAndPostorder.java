package tree;

import java.util.HashMap;
import java.util.Map;

// 这道题和lc105类似
// postorder的最右边的点可以用来分割inorder
public class LC106_ConstructBTFromInorderAndPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();

        //先将inorder的index存入map中
        for(int i = 0; i < inorder.length; i++){
            Integer put = map.put(inorder[i], i);
        }

        return helper(inorder, postorder, 0, inorder.length-1,
                0, postorder.length-1, map);
    }

    private TreeNode helper(int[] inorder,
                            int[] postorder,
                            int inStart,
                            int inEnd,
                            int postStart,
                            int postEnd,
                            Map<Integer, Integer> map) {
        if(inStart > inEnd || postStart < 0){
            return null;
        }

        int rootIndex = map.get(postorder[postEnd]);
        TreeNode root = new TreeNode(postorder[postEnd]);

        root.left = helper(inorder,
                postorder,
                inStart,
                rootIndex-1,
                postStart,
                postStart+rootIndex-inStart-1,map
        );

        root.right = helper(inorder,
                postorder,
                rootIndex+1,
                inEnd,
                postStart+rootIndex-inStart,
                postEnd-1,
                map);
        return root;
    }
}
