package tree;

import java.util.*;

/**
 * https://www.youtube.com/watch?v=1FJDyBSfEbo
 * 这道题见上，因为他不一定是连续的
 * 就是说，不能只比较父节点，可能是老以前的节点
 *
 * 这道题核心还是中序遍历！！
 * 如果使用中序遍历的话就可以用我的方法了应该！
 *
 */

public class LC501_FindModeInBST {
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Map<Integer, Integer> map= new HashMap<>();
        map.put(root.val, 1);

        dfs(root.left, map, root.val);
        dfs(root.right, map, root.val);

        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxEntry == null || entry.getValue()
                    .compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        int modeNum = maxEntry.getValue();
        List<Integer> tmpRes = new ArrayList<>();
        tmpRes.add(maxEntry.getKey());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()==modeNum && entry.getKey()!=tmpRes.get(0)){
                tmpRes.add(entry.getKey());
            }
        }

        int[] res = new int[tmpRes.size()];
        for (int i = 0; i < tmpRes.size(); i++){
            res[i] = tmpRes.get(i);
        }
        return res;
    }

    private void dfs(TreeNode root,
                     Map<Integer, Integer> map,
                     int parentVal) {
        if(root == null){
            return;
        }
        if(map.containsKey(root.val)){
            map.put(root.val, map.get(root.val)+1);
        } else {
            map.put(root.val, 1);
        }

        dfs(root.left, map, root.val);
        dfs(root.right, map, root.val);
        return;
    }
}

class LC501_Solution {
    int preVal = 0, curTimes = 0, maxTimes = 0;
    ArrayList<Integer> list = new ArrayList<Integer>();
    public int[] findMode(TreeNode root) {
        traversal(root);
        //list转换为int[]
        int size = list.size();
        int[] ans = new int[size];
        for(int i = 0; i < size; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    //二叉搜索树中序遍历是递增顺序
    //因为他是中序遍历，走到右边的时候，什么都不会比较然后直接走右边的左边，
    // 这样就可以非常节省空间！！
    public void traversal(TreeNode root){
        if(root != null){
            traversal(root.left);
            //判断当前值与上一个值的关系, 更新 curTimes 和 preVal
            if(preVal == root.val){
                curTimes++;
            }else{
                preVal = root.val;
                curTimes = 1;
            }
            //判断当前数量与最大数量的关系, 更新 list 和 maxTimes
            if(curTimes == maxTimes){
                list.add(root.val);
            }else if(curTimes > maxTimes){
                list.clear();
                list.add(root.val);
                maxTimes = curTimes;
            }
            traversal(root.right);
        }
    }
}
