package graph;

import java.util.*;

public class LC1462_CourseScheduleIV {
    List<Set<Integer>> memo=new ArrayList<>();
    List<List<Integer>> graph=new ArrayList<>();
    boolean[] vis;
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        for (int i = 0; i <n ; i++) {
            // 对于每个节点，利用一个memo去记录其全部后续节点
            memo.add(new HashSet<>());
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i <prerequisites.length ; i++) {
            int src=prerequisites[i][0];
            int des=prerequisites[i][1];
            graph.get(src).add(des);
        }
        vis=new boolean[n];
        for (int i = 0; i <n ; i++) {
            if (vis[i]==false){
                dfs(i);
            }
        }
        List<Boolean> ans=new ArrayList<>();
        for (int i = 0; i <queries.length ; i++) {
            int src=queries[i][0];
            int des=queries[i][1];
            if (memo.get(src).contains(des)){
                ans.add(true);
            }else{
                ans.add(false);
            }
        }
        return ans;
    }
    private void dfs(int start){
        vis[start]=true;
        List<Integer> ne=graph.get(start);
        for(int temp:ne){
            if (!vis[temp]){
                dfs(temp);
            }
            memo.get(start).addAll(memo.get(temp));
            memo.get(start).add(temp);
        }
    }
}
