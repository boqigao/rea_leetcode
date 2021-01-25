package tree;


import java.util.HashMap;
import java.util.Map;

/**
 * 这类题目也是非常常见
 * 举例子某个树是：
 *      3
 *    9   20
 * 8 null 15 7
 *
 * preorder的话是：根，左，右
 * 因此 preorder : 3 9 8 20 15 7
 * inorder的话是：左 根 右
 * 因此 inorder: 8 9 3 15 20 7
 *
 * 做法大概是这样： 首先我们能看到从preorder看到根节点是3
 * 因此在inorder中，我们可以把根节点的左右节点分开了！
 * 这时候我们可以观察到，根节点左边有2个点，8 9， 根节点右边有3个点
 * 15,20,7
 * 因此这时候可以返回preorder知道
 * 在8 9 中第一个出现的9 是根节点， 在20 15 7 中第一个出现的20 是右边的根
 *
 * 返回inorder看的话， 8 9（9是根），那么8一定是左节点
 * 15 20 7的话，那么15左 20（根） 7 右边
 */
public class LC105_ConstructBTByPreAndInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> map = new HashMap<>();

        //先将inorder的index存入map中
        for(int i = 0; i < inorder.length; i++){
            Integer put = map.put(inorder[i], i);
        }
        return helper(preorder,inorder,0,0,inorder.length-1,map);

    }

    private TreeNode helper(int[] preorder,
                            int[] inorder,
                            int preStart,
                            int inStart,
                            int inEnd,
                            Map<Integer, Integer> map) {
        if(preStart>=preorder.length || inStart > inEnd) return null;

        //在preStart的位置为root
        TreeNode root = new TreeNode(preorder[preStart]);

        //然后拿到rootIndex在inorder里面的位置
        int rootIndex = map.get(preorder[preStart]);
        /*
        preStart + 1:对于左子树的话，prestart之后的那个必然是左子树的root
        inStart的话：从 inStart到inorder的根节点-1的地方就是左边的子树
         */
        root.left = helper(preorder, inorder, preStart + 1,
                inStart, rootIndex-1, map);

        /*
        preStart+rootIndex-inStart+1：对于右子树的话，右子树的的根节点在pre的位置是
        [根 左 右]，因此要根节点加上 rootIndex-inStart 再+1
        这个意思大概就是说多层次了以后，rootIndex-inStart是左边的宽度，加上这个以后再加一就是右边的宽度
        inStart的话：从rootIndex+1到inEnd就是右边的子树
         */
        root.right = helper(preorder,inorder, preStart+rootIndex-inStart+1,
                rootIndex+1, inEnd,map);

        return root;
    }
}
