package tree;

// 这道题的核心问题是，给你的已经是一个排序好的数组
// BST是左边孩子<根节点<右边孩子
// 因此对于一个排序好的数组来说，根节点就直接是中间节点，然后我们直接再递归找左右两边子树的中间节点
// 将其作为根节点的左右孩子就行了
// 上面的步骤类似于一个binary search

public class LC108_Convert_sorted_array_to_BST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;

        return constructTreeFromArray(nums, 0, nums.length-1);

    }

    public TreeNode constructTreeFromArray(int[] nums, int left, int right) {
        // 如果左边比右边大了，说明已经没有新的节点了， 那就在将null加在其儿子下面
        if(left > right) return null;

        // 找到中间节点的值
        int midPoint = left + (right-left) / 2;

        // 设定中间节点，作为返回值 （这个中间节点可能是上层根节点的左儿子或者右儿子）
        TreeNode node = new TreeNode(nums[midPoint]);

        // 左儿子就是找binary search左边的中间节点
        node.left = constructTreeFromArray(nums, left, midPoint - 1);

        // 右儿子同理
        node.right = constructTreeFromArray(nums, midPoint + 1, right);

        return node;
    }

}
